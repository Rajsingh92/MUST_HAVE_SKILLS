from employees import Employees
from proxy import Proxy

def get_employees_collection(reqid):
    return Proxy(Employees(), reqid)
