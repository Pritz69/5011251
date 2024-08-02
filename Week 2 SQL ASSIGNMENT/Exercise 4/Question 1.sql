CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
) RETURN NUMBER IS
    v_Age NUMBER;
BEGIN
    
    SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12)
    INTO v_Age
    FROM dual;

    RETURN v_Age;
EXCEPTION
    WHEN OTHERS THEN
        
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        RETURN NULL; -- Return NULL in case of an error
END CalculateAge;
/
DECLARE
    v_Age NUMBER;
BEGIN
    v_Age := CalculateAge(TO_DATE('1980-01-15', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('The age is: ' || v_Age);
END;
/

---Scenario 1: Calculate the age of customers for eligibility checks.
---o	Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.
