from annual import Annual
from datetime import datetime, timedelta

class AnnualCorporate(Annual):

    @property
    def price(self):
        return super().price * .8
