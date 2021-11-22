import abc

class AbsTree(abc.ABC):

    @abc.abstractmethod
    def get_oldest(self):
        pass

    @abc.abstractmethod
    def pretty_print(self):
        pass
