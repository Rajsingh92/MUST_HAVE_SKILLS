import abc

class AbsCar(abc.ABC):
    @abc.abstractproperty
    def description(self):
        pass

    @abc.abstractproperty
    def cost(self):
        pass
