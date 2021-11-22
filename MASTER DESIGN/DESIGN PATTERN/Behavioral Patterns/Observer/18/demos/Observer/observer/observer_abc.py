import abc

class AbsObserver(abc.ABC):

    @abc.abstractmethod    
    def update(self, value):
        pass
