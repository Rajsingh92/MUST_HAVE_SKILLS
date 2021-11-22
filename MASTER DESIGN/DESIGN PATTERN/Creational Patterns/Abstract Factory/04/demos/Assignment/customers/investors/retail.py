from ..abs_cust import AbsCust


class Retail(AbsCust):
    def report_type(self):
        print('"%s" is a retail investor.' % self.name)