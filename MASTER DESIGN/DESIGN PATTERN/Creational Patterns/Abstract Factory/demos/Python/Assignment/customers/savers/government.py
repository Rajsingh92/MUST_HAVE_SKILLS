from ..abs_cust import AbsCust


class Government(AbsCust):
    def report_type(self):
        print('"%s" is a government saver.' % self.name)
