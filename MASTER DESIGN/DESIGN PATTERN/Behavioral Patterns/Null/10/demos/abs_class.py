import abc

class AbsClass(metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def do_something(self, value):
        pass