CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN Accounts.AccountID%TYPE,
    p_DestinationAccountID IN Accounts.AccountID%TYPE,
    p_Amount IN NUMBER
) IS
    v_SourceBalance Accounts.Balance%TYPE;
BEGIN
    -- Check if the source account has sufficient balance
    SELECT Balance INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = p_SourceAccountID;
    
    IF v_SourceBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    -- Begin transaction
    BEGIN
        -- Deduct the amount from the source account
        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_SourceAccountID;

        -- Add the amount to the destination account
        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_DestinationAccountID;

        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            -- Handle exceptions
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