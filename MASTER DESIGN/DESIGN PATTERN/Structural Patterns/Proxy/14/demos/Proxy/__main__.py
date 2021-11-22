from factory import get_employees_collection

def print_employee_details(empids, reqid):
    employees = get_employees_collection(reqid)
    for e in employees.get_employee_info(empids):
        print (
            f'Employee Id: {e.empid}, ' + 
            f'Name: {e.name}, ' + 
            f'Birthdate: {e.birthdate},' + 
            f'Salary: {e.salary}'
            )

print("Requestor authorized to see everything:")
print_employee_details([1, 2], 101)

print("Requestor is an ordinary employee.")
print_employee_details([1, 2, 3, 4], 3)
