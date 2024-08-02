---Scenario 1: Group all customer-related procedures and functions into a package.
---o	Question: Create a package CustomerManagement with procedures for adding a new customer, updating customer details, and a function to get customer balance.


CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddNewCustomer(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_DOB IN DATE, p_Balance IN NUMBER);


    PROCEDURE UpdateCustomerDetails(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_Balance IN NUMBER);

 
    FUNCTION GetCustomerBalance(p_CustomerID IN NUMBER) RETURN NUMBER;
END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS


    PROCEDURE AddNewCustomer(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_DOB IN DATE, p_Balance IN NUMBER) IS
    BEGIN
        BEGIN
            INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
            VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
            COMMIT;
        EXCEPTION
            WHEN DUP_VAL_ON_INDEX THEN
                DBMS_OUTPUT.PUT_LINE('Customer with ID ' || p_CustomerID || ' already exists.');
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        END;
    END AddNewCustomer;

  
    PROCEDURE UpdateCustomerDetails(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_Balance IN NUMBER) IS
    BEGIN
        BEGIN
            UPDATE Customers
            SET Name = p_Name, Balance = p_Balance, LastModified = SYSDATE
            WHERE CustomerID = p_CustomerID;
            
            IF SQL%ROWCOUNT = 0 THEN
                DBMS_OUTPUT.PUT_LINE('Customer with ID ' || p_CustomerID || ' does not exist.');
            ELSE
                COMMIT;
            END IF;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        END;
    END UpdateCustomerDetails;

 
    FUNCTION GetCustomerBalance(p_CustomerID IN NUMBER) RETURN NUMBER IS
        v_Balance NUMBER;
    BEGIN
        BEGIN
            SELECT Balance INTO v_Balance
            FROM Customers
            WHERE CustomerID = p_CustomerID;

            RETURN v_Balance;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                DBMS_OUTPUT.PUT_LINE('Customer with ID ' || p_CustomerID || ' does not exist.');
                RETURN NULL;
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
                RETURN NULL;
        END;
    END GetCustomerBalance;

END CustomerManagement;
/
BEGIN
    CustomerManagement.AddNewCustomer(
        p_CustomerID => 123,
        p_Name => 'Johnyyyy Doeeeeee',
        p_DOB => TO_DATE('1990-01-01', 'YYYY-MM-DD'),
        p_Balance => 10002
    );
END;
/
SELECT * FROM CUSTOMERS;

BEGIN
    CustomerManagement.UpdateCustomerDetails(
        p_CustomerID => 123,
        p_Name => 'John Doe Updated',
        p_Balance => 15002
    );
END;
/
SELECT * FROM CUSTOMERS;

DECLARE
    v_Balance NUMBER;
BEGIN
    v_Balance := CustomerManagement.GetCustomerBalance(p_CustomerID => 123);
    DBMS_OUTPUT.PUT_LINE('Customer Balance: ' || v_Balance);
END;
/

---SQL%ROWCOUNT:

---After executing an UPDATE (or INSERT/DELETE), SQL%ROWCOUNT returns the number of rows affected by that operation.
---If you update a row in the database, SQL%ROWCOUNT will be 1. If no rows are updated (for example, if the WHERE clause does not match any rows), SQL%ROWCOUNT will be 0.

