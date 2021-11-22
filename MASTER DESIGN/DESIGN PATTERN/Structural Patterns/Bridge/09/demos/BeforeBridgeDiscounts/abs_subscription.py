import abc

class Subscription(abc.ABC):

    def __init__(self, subscriber, enrolled):
        self._subscriber = subscriber
        self._enrolled = enrolled

    @property
    def subscriber(self):
        return self._subscriber

    @property
    def enrolled(self):
        return self._enrolled

    @abc.abstractproperty
    def price(self):
        pass

    @abc.abstractproperty
    def expiration(self):
        pass
