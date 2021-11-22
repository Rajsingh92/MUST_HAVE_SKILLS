import abc

STATETRANSITIONERROR = 'Cannot add an item while in the %s state'

class AbsState(metaclass=abc.ABCMeta):
    def __init__(self, context):
        self._cart = context

    def add_item(self):
        self._transition_error()

    def remove_item(self):
        self._transition_error()

    def checkout(self):
        self._transition_error()

    def pay(self):
        self._transition_error()

    def empty_cart(self):
        self._transition_error()

    def suspend(self):
        self._cart.suspended_state = self._cart.state
        self._cart.state = self._cart.suspended

    def resume(self):
        self._transition_error()

    def _transition_error(self):
        raise NotImplementedError(
            STATETRANSITIONERROR % self._cart.state.__class__.__name__)
