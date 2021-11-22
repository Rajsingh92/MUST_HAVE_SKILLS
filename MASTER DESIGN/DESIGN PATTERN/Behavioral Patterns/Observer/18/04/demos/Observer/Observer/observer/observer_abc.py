import abc

class AbsObserver(object):
    __metaclass__ = abc.ABCMeta
    
    @abc.abstractmethod    
    def update(self, value):
        pass