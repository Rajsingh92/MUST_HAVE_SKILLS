from datetime import datetime
from employee import Employee
from employee_collection import Employees
from department import Department
from department_collection import Departments

TESTEMPLOYEES = (
    (1, 'Douglas Adams', datetime(1942, 7, 6)),
    (2, 'Sherlock Holmes', datetime(1887, 3, 15)),
    (3, 'Albert Einstein', datetime(1915, 11, 25)),
    (4, 'Sir John A Macdonald', datetime(1867, 8, 1)),
    (5, 'Theodore Roosevelt', datetime(1901, 9, 14))
)

employees = Employees()
for empid, name, hiredate in TESTEMPLOYEES:
    employees.add_employee(
        Employee(empid, name, hiredate)
    )

TESTDEPARTMENTS = (
    (101, 'Sci-Fi Commedy', datetime(2010, 10, 1)),
    (102, 'Mystery', datetime(2012, 2, 13)),
    (103, 'Physics', datetime(2014, 5, 14)),
    (104, 'Politics', datetime(2016, 7, 28)),
    (201, 'POTUS', datetime(1776, 7, 4))
)

departments = Departments()
for deptid, name, date_established in TESTDEPARTMENTS:
    departments.add_department(
        Department(deptid, name, date_established)
    )
