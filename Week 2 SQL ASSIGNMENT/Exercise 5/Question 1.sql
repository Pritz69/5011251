---Scenario 1: Automatically update the last modified date when a customer's record is updated.
---o	Question: Write a trigger UpdateCustomerLastModified that updates the LastModified column of the Customers table to the current date whenever a customer's record is updated.


CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    
    :NEW.LastModified := SYSDATE;
END;
/

UPDATE Customers
SET Name = 'John Doe'
WHERE CustomerID = 1;

SELECT * FROM CUSTOMERS;





