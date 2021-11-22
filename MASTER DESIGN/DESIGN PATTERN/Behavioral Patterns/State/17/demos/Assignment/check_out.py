from abs_state import AbsState

class AtCheckOut(AbsState):

    def remove_item(self):
        self._cart.items -= 1
        if not self._cart.items:
            self._cart.state = self._cart.empty

    def pay(self):
        self._cart.state = self._cart.paid_for

    def empty_cart(self):
        self._cart.items = 0
        self._cart.state = self._cart.empty
