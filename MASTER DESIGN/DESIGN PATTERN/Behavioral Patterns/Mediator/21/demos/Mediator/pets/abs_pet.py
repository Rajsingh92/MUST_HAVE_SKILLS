import abc

class AbsPet(abc.ABC):
    
    def __init__(self, name):
        self.name = name
        self.mediator = None
