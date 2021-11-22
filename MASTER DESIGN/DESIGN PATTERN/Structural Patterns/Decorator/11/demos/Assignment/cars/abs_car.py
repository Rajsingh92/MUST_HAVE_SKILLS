import abc

class AbsCar(metaclass=abc.ABCMeta):
    @abc.abstractproperty
    def description(self):
        pass

    @abc.abstractproperty
    def cost(self):
        pass

    @abc.abstractproperty
    def premium(self):
        pass
