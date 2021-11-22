import abc

class AbsHandler(abc.ABC):

    @abc.abstractproperty
    def successor(self):
        pass

    @abc.abstractmethod
    def handle(self, request):
        pass
