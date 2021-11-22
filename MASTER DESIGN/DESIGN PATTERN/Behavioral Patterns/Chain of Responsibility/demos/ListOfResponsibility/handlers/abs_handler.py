import abc

class AbsHandler(abc.ABC):

    @abc.abstractmethod
    def handle(self, request):
        pass
