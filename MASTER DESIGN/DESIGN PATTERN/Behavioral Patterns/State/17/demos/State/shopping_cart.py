from empty import Empty
from not_empty import NotEmpty
from check_out import AtCheckOut
from paid_for import PaidFor

class ShoppingCart:
    def __init__(self):
        self.empty = Empty(self)
        self.not_empty = NotEmpty(self)
        self.check_out = AtCheckOut(self)
        self.paid_for = PaidFor(self)

        self.items = 0
        self.state = self.empty

    def add_item(self):
        self.state.add_item()

    def remove_item(self):
        self.state.remove_item()

    def checkout(self):
        self.state.checkout()

    def pay(self):
        self.state.pay()

    def empty_cart(self):
        self.state.empty_cart()
