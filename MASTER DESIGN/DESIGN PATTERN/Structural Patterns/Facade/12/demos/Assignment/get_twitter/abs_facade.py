import abc

class AbsFacade(abc.ABC):
    @abc.abstractmethod
    def get_twitter(self):
        pass
