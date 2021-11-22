from customer import Customers
# from customer import Customer # not thread safe
from cust_proxy import CustProxy # thread safe

CUSTOMERS = Customers({
    1: CustProxy(1, "Joe's Pizza"),
    2: CustProxy(2, "Metropolitan Opera"),
    3: CustProxy(3, "Ma Bell"),
    42: CustProxy(42, "Restaurant at the end of the Universe")
})
