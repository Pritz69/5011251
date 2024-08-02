---Scenario 2: A customer can be promoted to VIP status based on their balance.
---o	Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.


ALTER TABLE Customers
ADD IsVIP NUMBER(1) DEFAULT 0;

BEGIN
    FOR customer_record IN (
        SELECT CustomerID, Balance
        FROM Customers
    ) LOOP
        IF customer_record.Balance > 10000 THEN
            
            UPDATE Customers
            SET IsVIP = 1
            WHERE CustomerID = customer_record.CustomerID;
            
        END IF;
    END LOOP;
END;
/
SELECT * FROM CUSTOMERS;
