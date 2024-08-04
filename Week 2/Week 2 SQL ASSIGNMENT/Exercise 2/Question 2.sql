CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN Employees.EmployeeID%TYPE,
    p_Percentage IN NUMBER
) IS
    v_OldSalary Employees.Salary%TYPE;
BEGIN
    -- Check if the employee exists
    SELECT Salary
    INTO v_OldSalary
    FROM Employees
    WHERE EmployeeID = p_EmployeeID;
    
    -- Update the salary
    UPDATE Employees
    SET Salary = Salary * (1 + p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle the exception if the employee ID does not exist
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_EmployeeID || ' does not exist.');
    WHEN OTHERS THEN
        -- Handle other exceptions
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/

BEGIN
    UpdateSalary(p_EmployeeID => 1, p_Percentage => 10);
END;
/

BEGIN
    UpdateSalary(123,10);
END;
/
