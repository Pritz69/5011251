CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN Employees.Department%TYPE,
    p_BonusPercentage IN NUMBER
) IS
BEGIN
    -- Update the salary for employees in the specified department by applying the bonus percentage
    UPDATE Employees
    SET Salary = Salary * (1 + p_BonusPercentage / 100)
    WHERE Department = p_Department;
    
    -- Commit the transaction to save changes
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Salaries updated with a bonus of ' || p_BonusPercentage || '% for department ' || p_Department || '.');
EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions that occur
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK; -- Rollback the transaction in case of an error
END UpdateEmployeeBonus;
/

SELECT * FROM EMPLOYEES;

BEGIN
    UpdateEmployeeBonus(p_Department => 'Sales', p_BonusPercentage => 10);
END;
/

SELECT * FROM EMPLOYEES;

