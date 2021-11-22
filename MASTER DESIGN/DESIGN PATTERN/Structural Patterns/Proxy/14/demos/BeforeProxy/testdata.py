from employee import Employee
from access_control import AccessControl

EMPLOYEES = {
    1: Employee(1, 'Bob', '4 Jul 1994', 80000.00),
    2: Employee(2, 'Carol', '28 May 1992', 85000.00),
    3: Employee(3, 'Ted', '18 Feb 1988', 55000.00),
    4: Employee(4, 'Alice', '25 Nov 1987', 40000.00),
    101: Employee(101, 'Morgan the Manager', '14 Mar 1975', 100000.00)
}

ACCESSCONTROL = {
    101: AccessControl(101, True)
}
