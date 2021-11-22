import abc

class Discount(abc.ABC):

    @abc.abstractproperty
    def discount(self):
        pass

class StudentDiscount(Discount):

    @property
    def discount(self):
        return 10
    
class CorporateDiscount(Discount):

    @property
    def discount(self):
        return 20

class NoDiscount(Discount):

    @property
    def discount(self):
        return 0
