from ..abs_cust import AbsCust


class Commercial(AbsCust):
    def report_type(self):
        print('"%s" is a commercial saver.' % self.name)