from get_employees import PROVIDER
from get_employees.facade_factory import FacadeFactory

def main():
    facade = FacadeFactory.create_facade(PROVIDER)
    facade.get_employees()

if __name__ == '__main__':
    main()
