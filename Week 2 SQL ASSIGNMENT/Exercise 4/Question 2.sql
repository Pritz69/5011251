---Scenario 2: The bank needs to compute the monthly installment for a loan.
---o	Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_LoanDurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyInstallment NUMBER;
    v_MonthlyInterestRate NUMBER;
    v_NumPayments NUMBER;
BEGIN
    
    v_MonthlyInterestRate := p_InterestRate / 12 / 100;
    
    v_NumPayments := p_LoanDurationYears * 12;

   
    IF v_MonthlyInterestRate > 0 THEN
        v_MonthlyInstallment := (p_LoanAmount * v_MonthlyInterestRate) /
            (1 - POWER(1 + v_MonthlyInterestRate, -v_NumPayments));
    ELSE
        -- If interest rate is 0, simply divide loan amount by number of payments
        v_MonthlyInstallment := p_LoanAmount / v_NumPayments;
    END IF;

    RETURN v_MonthlyInstallment;
END CalculateMonthlyInstallment;
/
DECLARE
    v_MonthlyInstallment NUMBER;
BEGIN
    v_MonthlyInstallment := CalculateMonthlyInstallment(
        p_LoanAmount => 10000,
        p_InterestRate => 5,
        p_LoanDurationYears => 10
    );
    DBMS_OUTPUT.PUT_LINE('The monthly installment is: ' || v_MonthlyInstallment);
END;
/
