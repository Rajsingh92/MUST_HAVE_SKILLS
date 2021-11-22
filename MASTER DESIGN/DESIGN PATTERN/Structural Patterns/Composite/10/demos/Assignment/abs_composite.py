import abc

class AbsComposite(metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def get_oldest(self):
        pass

    @abc.abstractmethod
    def distribute_inheritance(self, value):
        pass