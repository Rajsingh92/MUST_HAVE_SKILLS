from shopping_cart import ShoppingCart

def main():
    print("====> first cart")
    cart = ShoppingCart()
    cart.add_item()
    cart.remove_item()
    cart.add_item()
    cart.add_item()
    cart.add_item()
    cart.remove_item()
    cart.checkout()
    cart.pay()

    # Go shopping again
    print("====> second cart")
    cart = ShoppingCart()
    cart.add_item()
    cart.add_item()
    cart.checkout()
    cart.empty_cart()
    cart.add_item()
    cart.checkout()
    cart.pay()

    # Try to add another item
    print('====> Expect an error here.')
    cart.add_item()

main()
