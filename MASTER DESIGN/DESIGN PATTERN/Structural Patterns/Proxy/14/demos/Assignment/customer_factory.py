from mock_customer import CUSTOMERS
from customer import Customers

def get_customers_collection():
    return Customers(CUSTOMERS)
