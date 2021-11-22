from abs_state import AbsState

class NotEmpty(AbsState):

    def add_item(self):
        self._cart.items += 1

    def remove_item(self):
        self._cart.items -= 1
        if not self._cart.items:
            self._cart.state = self._cart.empty

    def checkout(self):
        self._cart.state = self._cart.check_out
