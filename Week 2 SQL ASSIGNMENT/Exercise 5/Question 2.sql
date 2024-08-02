---Scenario 2: Maintain an audit log for all transactions.
---o	Question: Write a trigger LogTransaction that inserts a record into an AuditLog table whenever a transaction is inserted into the Transactions table.


CREATE TABLE AuditLog (
    TransactionID NUMBER PRIMARY KEY,  
    AuditDate DATE,
    Action VARCHAR2(50),
    FOREIGN KEY (TransactionID) REFERENCES Transactions(TransactionID) 
);
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AuditDate, Action)
    VALUES (
        :NEW.TransactionID,  
        SYSDATE,
        'INSERT'
    );
END;
/

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (11, 8, TO_DATE('2024-07-28', 'YYYY-MM-DD'), 500.00, 'Withdrawal');

SELECT * FROM AuditLog;
