# Define the states

EMPTY = 0
NOT_EMPTY = 1
AT_CHECKOUT = 2
PAID_FOR = 3

class ShoppingCart:

    def __init__(self):
        self.state = EMPTY
        self._items = 0

    def add_item(self):
        if self.state == EMPTY:
            print('You added the first item')
            self.state = NOT_EMPTY
            self._items += 1

        elif self.state == NOT_EMPTY:
            self._items += 1
            print(f'You now have {self._items} items in your cart')

        elif self.state == AT_CHECKOUT:
            print("You can't add new items at checkout!")

        else: # state == PAID_FOR
            print("You can't add items after payment!")

    def remove_item(self):
        if self.state == EMPTY:
            print('Your cart is empty! Nothing to remove!!')

        elif self.state == NOT_EMPTY:
            self._items -= 1
            print(f'You now have {self._items} items in your cart')
            if not self._items:
                self.state = EMPTY

        elif self.state == AT_CHECKOUT:
            self._items -= 1
            print(f'You now have {self._items} items in your cart')
            if not self._items:
                self.state = EMPTY
            else:
                self.state = NOT_EMPTY

        else: # state == PAID_FOR
            print("You can't add items after payment!")

    def checkout(self):
        if self.state == EMPTY:
            print("Your cart is empty. Go shopping!")

        elif self.state == NOT_EMPTY:
            print(f'You now have {self._items} items in your cart')
            self.state = AT_CHECKOUT

        elif self.state == AT_CHECKOUT:
            print('You are already at check out!')

        else: # state == PAID_FOR
            print("You can't go back to checkout after payment.")

    def paid_for(self):
        if self.state == EMPTY:
            print("Your cart is empty. How did you get here?")

        elif self.state == NOT_EMPTY:
            print("You must go to checkout for payment.")

        elif self.state == AT_CHECKOUT:
            print(f'You paid for {self._items} items.')
            self._items = 0
            self.state = EMPTY

        else: # state == PAID_FOR
            print("You already paid for your purchases.")
