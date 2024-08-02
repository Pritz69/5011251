---Scenario 3: Customers should be able to transfer funds between their accounts.
---o	Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN Accounts.AccountID%TYPE,
    p_DestinationAccountID IN Accounts.AccountID%TYPE,
    p_Amount IN NUMBER
) IS
    v_SourceBalance Accounts.Balance%TYPE;
BEGIN

    SELECT Balance INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = p_SourceAccountID;
    
    IF v_SourceBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

   
    BEGIN
        
        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_SourceAccountID;

   
        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_DestinationAccountID;

        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    EXCEPTION
        WHEN OTHERS THEN
    
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK; -- Rollback the transaction in case of an error
    END;
END TransferFunds;
/
BEGIN
    TransferFunds(p_SourceAccountID => 1, p_DestinationAccountID => 2, p_Amount => 500);
END;
/
BEGIN
    TransferFunds(p_SourceAccountID => 1, p_DestinationAccountID => 2, p_Amount => 50000000000);
END;
/
