from .abs_cust import AbsCust

class SMBCust(AbsCust):
    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, name):
        self._name = name

    def send_invoice(self):
        print('Sending invoice to government customer "%s".' % self._name)