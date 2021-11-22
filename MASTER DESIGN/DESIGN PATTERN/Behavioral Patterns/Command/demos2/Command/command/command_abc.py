import abc


class AbsCommand(abc.ABC):

    @abc.abstractmethod
    def execute(self):
        pass
