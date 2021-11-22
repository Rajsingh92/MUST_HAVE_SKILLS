import abc

class AbsObserver(object):
    __metaclass__ = abc.ABCMeta
    
    @abc.abstractmethod    
    def update(self, value):
        pass

    def __enter__(self):
        return self

    @abc.abstractmethod    
    def __exit__(self, exc_type, exc_value, traceback):
        pass        