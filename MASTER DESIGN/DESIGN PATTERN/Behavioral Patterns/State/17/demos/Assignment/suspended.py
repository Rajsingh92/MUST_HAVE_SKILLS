from abs_state import AbsState

class Suspended(AbsState):

    def suspend(self):
        self._transition_error()

    def resume(self):
        self._cart.state = self._cart.suspended_state
