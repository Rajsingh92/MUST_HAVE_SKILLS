import abc

class Subscription(abc.ABC):

    def __init__(self, subscriber, enrolled, discount):
        self._subscriber = subscriber
        self._enrolled = enrolled
        self._discount = discount()

    @property
    def subscriber(self):
        return self._subscriber

    @property
    def enrolled(self):
        return self._enrolled

    @abc.abstractproperty
    def price_base(self):
        pass

    @property
    def price(self):
        discount = self._discount.discount
        return self.price_base * (1 - discount/100)

    @abc.abstractproperty
    def expiration(self):
        pass
