DECLARE
    -- Define a cursor to select all accounts
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts;
    -- Define a variable to hold each record fetched by the cursor
    v_Account ApplyAnnualFee%ROWTYPE;
    -- Maintenance fee to deduct
    v_AnnualFee NUMBER := 100;

BEGIN
    -- Step 2: Open the cursor
    OPEN ApplyAnnualFee;
    -- Step 3: Loop to fetch and process each account
    LOOP
        FETCH ApplyAnnualFee INTO v_Account;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;
        -- Step 4: Apply the annual fee
        IF v_Account.Balance >= v_AnnualFee THEN
            UPDATE Accounts
            SET Balance = Balance - v_AnnualFee
            WHERE AccountID = v_Account.AccountID;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Insufficient balance for Account ID: ' || v_Account.AccountID);
        END IF;
    END LOOP;

    -- Step 5: Close the cursor
    CLOSE ApplyAnnualFee;

    -- Commit the changes
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions that occur
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
SELECT * FROM ACCOUNTS;
