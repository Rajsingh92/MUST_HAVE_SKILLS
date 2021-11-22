from testdata import employees, departments

def main():

    print("Employees:")

    for i in range(1, employees.headcount+1):
        e = employees.get_employee(i)
        print(f'Employee Id: {e.empid}; Name: {e.name}; Date of Hire: {e.hiredate}')

    print("Departments:")

    for i in range(*departments.departments_range):
        d = departments.get_department(i)
        print(f'Department Id: {d.deptid}; Name: {d.name}; Date Established: {d.date_established}')

    print_summary(employees)
    print_summary(departments)

def print_summary(collection):
    pass
    # what goes here?
    # for what in what?

if __name__ == '__main__':
    main()
