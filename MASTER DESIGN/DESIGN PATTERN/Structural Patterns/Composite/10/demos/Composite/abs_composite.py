import abc

class AbsComposite(abc.ABC):

    @abc.abstractmethod
    def get_oldest(self):
        pass
