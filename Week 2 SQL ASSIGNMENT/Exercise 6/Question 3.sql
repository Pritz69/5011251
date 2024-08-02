---Scenario 3: Update the interest rate for all loans based on a new policy.
---o	Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches all loans and updates their interest rates based on the new policy.


DECLARE
    
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans;
    
    v_Loan UpdateLoanInterestRates%ROWTYPE;
    
    v_NewInterestRate NUMBER := 0.5;

BEGIN
   
    OPEN UpdateLoanInterestRates;
   
    LOOP
        FETCH UpdateLoanInterestRates INTO v_Loan;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + v_NewInterestRate
        WHERE LoanID = v_Loan.LoanID;

 
        DBMS_OUTPUT.PUT_LINE('Updated Loan ID: ' || v_Loan.LoanID || 
                             ', New Interest Rate: ' || (v_Loan.InterestRate + v_NewInterestRate));
    END LOOP;

    CLOSE UpdateLoanInterestRates;
 
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions that occur
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
