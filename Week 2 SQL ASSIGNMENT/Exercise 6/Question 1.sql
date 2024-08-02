DECLARE
    -- Define a record type for transactions
    --TYPE TransactionRec IS RECORD (
    --    TransactionID Transactions.TransactionID%TYPE,
    --    AccountID Transactions.AccountID%TYPE,
    --    TransactionDate Transactions.TransactionDate%TYPE,
    --    Amount Transactions.Amount%TYPE,
    --    TransactionType Transactions.TransactionType%TYPE
    --);
    -- Define a cursor for retrieving transactions of the current month
    CURSOR GenerateMonthlyStatements IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    
    v_Transaction GenerateMonthlyStatements%ROWTYPE;
    --v_Transaction TransactionRec;
BEGIN
    
    OPEN GenerateMonthlyStatements;

    
    LOOP
        FETCH GenerateMonthlyStatements INTO v_Transaction;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

      
        DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || v_Transaction.TransactionID);
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_Transaction.AccountID);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || v_Transaction.TransactionDate);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_Transaction.Amount);
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || v_Transaction.TransactionType);
        DBMS_OUTPUT.PUT_LINE('-----------------------------------');
    END LOOP;

    
    CLOSE GenerateMonthlyStatements;

EXCEPTION
    WHEN OTHERS THEN
      
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (15, 1, TO_DATE('2024-08-01', 'YYYY-MM-DD'), 1000, 'DEPOSIT');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (16, 2, TO_DATE('2024-08-15', 'YYYY-MM-DD'), 500, 'WITHDRAWAL');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (17, 3, TO_DATE('2024-08-20', 'YYYY-MM-DD'), 1500, 'DEPOSIT');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (18, 4, TO_DATE('2024-07-25', 'YYYY-MM-DD'), 2000, 'DEPOSIT'); -- Older transaction


COMMIT;

---Scenario 1: Generate monthly statements for all customers.
---o	Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves all transactions for the current month and prints a statement for each customer.


