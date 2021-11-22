from .abs_factory import AbsFactory
from customers.investors.commercial import Commercial
from customers.investors.government import Government
from customers.investors.retail import Retail


class Investor(AbsFactory):
    @staticmethod
    def create_commercial():
        return Commercial

    @staticmethod
    def create_government():
        return Government

    @staticmethod
    def create_retail():
        return Retail
