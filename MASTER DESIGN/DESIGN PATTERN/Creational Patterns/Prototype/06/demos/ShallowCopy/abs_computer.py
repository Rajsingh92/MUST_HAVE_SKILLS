import abc

class AbsComputer(abc.ABC):
    @abc.abstractmethod
    def display(self):
        pass
