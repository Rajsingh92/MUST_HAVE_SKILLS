import abc


class AbsOrderCommand(abc.ABC):

    @abc.abstractproperty
    def name(self):
        pass

    @abc.abstractproperty
    def description(self):
        pass
