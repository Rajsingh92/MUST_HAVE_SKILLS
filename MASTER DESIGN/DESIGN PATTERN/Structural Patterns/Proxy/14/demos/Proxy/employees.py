from abs_employees import AbsEmployees
from testdata import EMPLOYEES

class Employees(AbsEmployees):

    def get_employee_info(self, empids):
        return (EMPLOYEES[empid]
                for empid in empids
                if empid in EMPLOYEES)
