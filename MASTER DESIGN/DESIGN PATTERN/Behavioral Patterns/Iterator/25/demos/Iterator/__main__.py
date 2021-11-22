from testdata import employees, departments

def main():
    print("Employees:")
    print_summary(employees)
    print("Departments:")
    print_summary(departments)

def print_summary(collection):
    for item in collection:
        print(f'Item Id: {item.number}; Name: {item.name}; Dated: {item.date}')

if __name__ == '__main__':
    main()
