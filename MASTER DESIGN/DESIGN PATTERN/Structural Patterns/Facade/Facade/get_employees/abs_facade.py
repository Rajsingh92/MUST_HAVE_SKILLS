import abc

class AbsFacade(abc.ABC):
    @abc.abstractmethod
    def get_employees(self):
        pass
