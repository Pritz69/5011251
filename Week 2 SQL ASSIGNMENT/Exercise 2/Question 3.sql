---o	Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists,
---    handle the exception by logging an error and preventing the insertion.

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN Customers.CustomerID%TYPE,
    p_Name IN Customers.Name%TYPE,
    p_DOB IN Customers.DOB%TYPE,
    p_Balance IN Customers.Balance%TYPE,
    p_LastModified IN Customers.LastModified%TYPE
) IS
BEGIN
   
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, p_LastModified);

        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            
            DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_CustomerID || ' already exists.');
        WHEN OTHERS THEN
           
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
END AddNewCustomer;
/
BEGIN
    AddNewCustomer(
        p_CustomerID => 1001,
        p_Name => 'John Doe',
        p_DOB => TO_DATE('1980-01-15', 'YYYY-MM-DD'),
        p_Balance => 5000,
        p_LastModified => SYSDATE
    );
END;
/
BEGIN
    AddNewCustomer(
        p_CustomerID => 1002,
        p_Name => 'Johnnnnn Doe',
        p_DOB => TO_DATE('1980-01-15', 'YYYY-MM-DD'),
        p_Balance => 500053,
        p_LastModified => SYSDATE
    );
END;
/
BEGIN
    AddNewCustomer(
        p_CustomerID => 1001,
        p_Name => 'Johnyyy Doe',
        p_DOB => TO_DATE('1980-01-15', 'YYYY-MM-DD'),
        p_Balance => 503300,
        p_LastModified => SYSDATE
    );
END;
/
