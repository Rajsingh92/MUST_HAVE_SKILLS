import abc

class AbsCommand(object):                           # Python 2.x
# class AbsCommand(object, metaclass=abc.ABCMeta):  # Python 3.x
    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def execute(self):
        pass
