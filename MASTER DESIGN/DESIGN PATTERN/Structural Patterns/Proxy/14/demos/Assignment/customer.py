class Customer:
    def __init__(self, custid, name):
        self._custid = custid
        self._name = name

    @property
    def custid(self):
        return self._custid

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, new_name):
        self._name = new_name

class Customers(dict):
    pass
