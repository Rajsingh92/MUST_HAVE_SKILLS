from abs_state import AbsState

class PaidFor(AbsState):

    def add_item(self):
        print('You already paid for your purchases. Want to shop some more? Get a new shopping cart!')

    def remove_item(self):
        print("You've already paid for your purchases and can't remove any.")

    def checkout(self):
        print('Why are you back here?  You already paid!')

    def pay(self):
        print("You already paid.  You can't pay twice!")

    def empty_cart(self):
        print('You paid already. Time to go home!')
