from monthly import Monthly
from datetime import datetime, timedelta

class MonthlyStudent(Monthly):

    @property
    def price(self):
        return super().price * .9
