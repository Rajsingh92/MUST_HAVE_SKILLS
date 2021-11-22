from .abs_factory import AbsFactory
from customers.savers.commercial import Commercial
from customers.savers.government import Government
from customers.savers.retail import Retail


class Saver(AbsFactory): 
    @staticmethod
    def create_commercial():
        return Commercial

    @staticmethod
    def create_government():
        return Government

    @staticmethod
    def create_retail():
        return Retail