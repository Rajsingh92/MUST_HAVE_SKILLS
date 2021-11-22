from testdata import EMPLOYEES, ACCESSCONTROL

def get_employee_info(empids, reqid):
    for empid in empids:
        if empid not in EMPLOYEES:
            continue
        e = EMPLOYEES[empid]
        details = f'Employee Id: {e.empid}, Name: {e.name}'

        if reqid in ACCESSCONTROL:
            if ACCESSCONTROL[reqid].can_see_personal:
                details += f', BirthDate: {e.birthdate}, Salary: {e.salary:.2f}'
        print(details)

get_employee_info([3, 4], 3) # requestor may not see personal data

get_employee_info([1, 2, 5], 101) # requestor *may* see personal data
