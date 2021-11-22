from shopping_cart import ShoppingCart

def main():
    cart = ShoppingCart()
    cart.add_item()
    cart.remove_item()
    cart.add_item()
    cart.add_item()
    cart.add_item()
    cart.remove_item()
    cart.checkout()
    cart.paid_for()
    cart.add_item()
    cart.checkout()
    cart.paid_for()

main()
