from abs_subscription import Subscription
from dateutil.relativedelta import relativedelta

class Monthly(Subscription):

    @property
    def price(self):
        return 50.00

    @property
    def expiration(self):
        return self._enrolled + relativedelta(months=1)
 