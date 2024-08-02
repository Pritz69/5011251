---Scenario 2: Create a package to manage employee data.
---o	Question: Write a package EmployeeManagement with procedures to hire new employees, update employee details, and a function to calculate annual salary.


CREATE OR REPLACE PACKAGE EmployeeManagement AS
   
    PROCEDURE HireNewEmployee(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2);
    

    PROCEDURE UpdateEmployeeDetails(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2);
    

    FUNCTION CalculateAnnualSalary(p_EmployeeID IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireNewEmployee(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2) IS
    BEGIN
        BEGIN
            INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
            VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, SYSDATE);
            COMMIT;
        EXCEPTION
            WHEN DUP_VAL_ON_INDEX THEN
                DBMS_OUTPUT.PUT_LINE('Employee with ID ' || p_EmployeeID || ' already exists.');
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        END;
    END HireNewEmployee;


    PROCEDURE UpdateEmployeeDetails(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2) IS
    BEGIN
        BEGIN
            UPDATE Employees
            SET Name = p_Name, Position = p_Position, Salary = p_Salary, Department = p_Department
            WHERE EmployeeID = p_EmployeeID;
            
            IF SQL%ROWCOUNT = 0 THEN
                DBMS_OUTPUT.PUT_LINE('Employee with ID ' || p_EmployeeID || ' does not exist.');
            ELSE
                COMMIT;
            END IF;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        END;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_EmployeeID IN NUMBER) RETURN NUMBER IS
        v_Salary NUMBER;
        v_AnnualSalary NUMBER;
    BEGIN
        BEGIN
            SELECT Salary INTO v_Salary
            FROM Employees
            WHERE EmployeeID = p_EmployeeID;

            v_AnnualSalary := v_Salary * 12;
            RETURN v_AnnualSalary;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                DBMS_OUTPUT.PUT_LINE('Employee with ID ' || p_EmployeeID || ' does not exist.');
                RETURN NULL;
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
                RETURN NULL;
        END;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
BEGIN
    EmployeeManagement.HireNewEmployee(
        p_EmployeeID => 101,
        p_Name => 'Alice Smith',
        p_Position => 'Software Engineer',
        p_Salary => 5000,
        p_Department => 'IT'
    );
END;
/
SELECT * FROM EMPLOYEES;

BEGIN
    EmployeeManagement.UpdateEmployeeDetails(
        p_EmployeeID => 101,
        p_Name => 'Alice Johnson',
        p_Position => 'Senior Software Engineer',
        p_Salary => 6000,
        p_Department => 'IT'
    );
END;
/
SELECT * FROM EMPLOYEES;

DECLARE
    v_AnnualSalary NUMBER;
BEGIN
    v_AnnualSalary := EmployeeManagement.CalculateAnnualSalary(p_EmployeeID => 101);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_AnnualSalary);
END;
/

