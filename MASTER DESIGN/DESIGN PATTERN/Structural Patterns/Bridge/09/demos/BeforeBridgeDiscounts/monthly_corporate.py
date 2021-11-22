from monthly import Monthly
from datetime import datetime, timedelta

class MonthlyCorporate(Monthly):

    @property
    def price(self):
        return super().price * .8

