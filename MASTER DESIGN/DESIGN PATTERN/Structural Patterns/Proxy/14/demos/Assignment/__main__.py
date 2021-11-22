from customer_factory import get_customers_collection

def main(custid, new_name):
    customers = get_customers_collection()
    print("Current customer name: %s" % customers[custid].name)
    customers[custid].name = new_name
    print("New customer name: %s" % customers[custid].name)

main(42, "Heart of Gold")
