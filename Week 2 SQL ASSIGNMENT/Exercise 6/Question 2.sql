---Scenario 2: Apply annual fee to all accounts.
---o	Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts an annual maintenance fee from the balance of all accounts.


DECLARE
    
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts;
   
    v_Account ApplyAnnualFee%ROWTYPE;
    
    v_AnnualFee NUMBER := 100;

BEGIN
   
    OPEN ApplyAnnualFee;
   
    LOOP
        FETCH ApplyAnnualFee INTO v_Account;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;
     
        IF v_Account.Balance >= v_AnnualFee THEN
            UPDATE Accounts
            SET Balance = Balance - v_AnnualFee
            WHERE AccountID = v_Account.AccountID;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Insufficient balance for Account ID: ' || v_Account.AccountID);
        END IF;
    END LOOP;

  
    CLOSE ApplyAnnualFee;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
SELECT * FROM ACCOUNTS;
