import threading
from customer import Customer

class CustProxy(Customer):
    name_lock = None

    @property
    def name(self):
        self.name_lock = threading.RLock()
        self.name_lock.acquire()
        return self._name

    @name.setter
    def name(self, value):
        self._name = value
        self.name_lock.release()
