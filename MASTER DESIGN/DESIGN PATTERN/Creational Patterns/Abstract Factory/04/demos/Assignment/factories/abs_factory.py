import abc

class AbsFactory(abc.ABC):
    @abc.abstractstaticmethod
    def create_saver():
        pass

    @abc.abstractstaticmethod
    def create_investor():
        pass

