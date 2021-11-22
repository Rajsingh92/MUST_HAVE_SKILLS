from testdata import employees

def main():

    print("Employees:")

    for i in range(1, employees.headcount+1):
        e = employees.get_employee(i)
        print(f'Employee Id: {e.empid}; Name: {e.name}; Date of Hire: {e.hiredate}')

if __name__ == '__main__':
    main()
