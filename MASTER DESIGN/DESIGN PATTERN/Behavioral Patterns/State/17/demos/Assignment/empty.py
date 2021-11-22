from abs_state import AbsState

class Empty(AbsState):

    def add_item(self):
        self._cart.items += 1
        self._cart.state = self._cart.not_empty
