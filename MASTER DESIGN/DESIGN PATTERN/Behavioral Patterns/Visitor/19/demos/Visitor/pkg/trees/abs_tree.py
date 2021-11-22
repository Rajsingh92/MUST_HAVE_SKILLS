import abc

class AbsTree(abc.ABC):

    @abc.abstractproperty
    def name(self):
        pass

    @abc.abstractmethod
    def accept(self, visitor):
        pass
