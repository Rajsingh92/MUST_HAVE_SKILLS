import abc

class AbsClass(abc.ABC):
    @abc.abstractmethod
    def do_something(self, value):
        pass
