DECLARE
    -- Define a cursor to select all loans
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans;
    -- Define a variable to hold each record fetched by the cursor
    v_Loan UpdateLoanInterestRates%ROWTYPE;
    -- New interest rate policy (e.g., increase all rates by 0.5%)
    v_NewInterestRate NUMBER := 0.5;

BEGIN
    -- Step 2: Open the cursor
    OPEN UpdateLoanInterestRates;
    -- Step 3: Loop to fetch and process each loan
    LOOP
        FETCH UpdateLoanInterestRates INTO v_Loan;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        -- Step 4: Update the loan interest rate based on the new policy
        UPDATE Loans
        SET InterestRate = InterestRate + v_NewInterestRate
        WHERE LoanID = v_Loan.LoanID;

        -- Optionally, print the updated loan details
        DBMS_OUTPUT.PUT_LINE('Updated Loan ID: ' || v_Loan.LoanID || 
                             ', New Interest Rate: ' || (v_Loan.InterestRate + v_NewInterestRate));
    END LOOP;
    -- Step 5: Close the cursor
    CLOSE UpdateLoanInterestRates;
    -- Commit the changes
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions that occur
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
