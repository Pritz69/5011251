---Scenario 3: Group all account-related operations into a package.
---o	Question: Create a package AccountOperations with procedures for opening a new account, closing an account, and a function to get the total balance of a customer across all accounts.



CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenNewAccount(p_AccountID IN NUMBER, p_CustomerID IN NUMBER, p_AccountType IN VARCHAR2, p_Balance IN NUMBER);
    

    PROCEDURE CloseAccount(p_AccountID IN NUMBER);
    

    FUNCTION GetTotalCustomerBalance(p_CustomerID IN NUMBER) RETURN NUMBER;
END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

 
    PROCEDURE OpenNewAccount(p_AccountID IN NUMBER, p_CustomerID IN NUMBER, p_AccountType IN VARCHAR2, p_Balance IN NUMBER) IS
    BEGIN
        BEGIN
            INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
            VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
            COMMIT;
        EXCEPTION
            WHEN DUP_VAL_ON_INDEX THEN
                DBMS_OUTPUT.PUT_LINE('Account with ID ' || p_AccountID || ' already exists.');
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        END;
    END OpenNewAccount;


    PROCEDURE CloseAccount(p_AccountID IN NUMBER) IS
    BEGIN
        BEGIN
            DELETE FROM Accounts
            WHERE AccountID = p_AccountID;
            
            IF SQL%ROWCOUNT = 0 THEN
                DBMS_OUTPUT.PUT_LINE('Account with ID ' || p_AccountID || ' does not exist.');
            ELSE
                COMMIT;
            END IF;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        END;
    END CloseAccount;

    FUNCTION GetTotalCustomerBalance(p_CustomerID IN NUMBER) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        BEGIN
            SELECT SUM(Balance) INTO v_TotalBalance
            FROM Accounts
            WHERE CustomerID = p_CustomerID;

            IF v_TotalBalance IS NULL THEN
                v_TotalBalance := 0;
            END IF;

            RETURN v_TotalBalance;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RETURN 0;
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
                RETURN NULL;
        END;
    END GetTotalCustomerBalance;

END AccountOperations;
/
BEGIN
    AccountOperations.OpenNewAccount(
        p_AccountID => 2001,
        p_CustomerID => 1,
        p_AccountType => 'Savings',
        p_Balance => 5000
    );
END;
/

SELECT * FROM ACCOUNTS;

BEGIN
    AccountOperations.CloseAccount(p_AccountID => 21);
END;
/

SELECT * FROM ACCOUNTS;

DECLARE
    v_TotalBalance NUMBER;
BEGIN
    v_TotalBalance := AccountOperations.GetTotalCustomerBalance(p_CustomerID => 1);
    DBMS_OUTPUT.PUT_LINE('Total Balance for Customer 1: ' || v_TotalBalance);
END;
/

