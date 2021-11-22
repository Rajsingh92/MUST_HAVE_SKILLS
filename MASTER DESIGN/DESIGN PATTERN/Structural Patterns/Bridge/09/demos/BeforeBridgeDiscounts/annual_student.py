from annual import Annual
from datetime import datetime, timedelta

class AnnualStudent(Annual):

    @property
    def price(self):
        return super().price * .9
