import abc

class AbsFactory(metaclass=abc.ABCMeta):
    @abc.abstractstaticmethod
    def create_saver():
        pass

    @abc.abstractstaticmethod
    def create_investor():
        pass

