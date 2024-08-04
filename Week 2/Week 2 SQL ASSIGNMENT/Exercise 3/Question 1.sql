CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest (
    p_InterestRate IN NUMBER
) IS
BEGIN
    -- Update the balance for all savings accounts by applying the specified interest rate
    UPDATE Accounts
    SET Balance = Balance * (1 + p_InterestRate / 100)
    WHERE AccountType = 'Savings';
    
    -- Commit the transaction to save changes
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts with an interest rate of ' || p_InterestRate || '%.');
EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions that occur
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK; -- Rollback the transaction in case of an error
END ProcessMonthlyInterest;
/
BEGIN
    ProcessMonthlyInterest(p_InterestRate => 1);
END;
/
SELECT * FROM ACCOUNTS;
