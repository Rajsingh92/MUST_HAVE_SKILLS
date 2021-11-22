import abc

class AbsFactory(metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def create_auto(self):
        pass