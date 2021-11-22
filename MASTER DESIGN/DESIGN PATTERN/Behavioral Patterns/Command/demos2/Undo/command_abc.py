import abc

class AbsCommand(abc.ABC):

    @abc.abstractmethod
    def execute(self):
        pass

    @abc.abstractmethod
    def undo(self):
        pass
