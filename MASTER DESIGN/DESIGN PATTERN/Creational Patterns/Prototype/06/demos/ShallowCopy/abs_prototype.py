import abc

class AbsPrototype(abc.ABC):
    @abc.abstractmethod
    def clone(self):
        pass