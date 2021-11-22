from abs_subscription import Subscription
from dateutil.relativedelta import relativedelta

class Annual(Subscription):

    @property
    def price_base(self):
        return 250.00

    @property
    def expiration(self):
        return self._enrolled + relativedelta(years=1)
