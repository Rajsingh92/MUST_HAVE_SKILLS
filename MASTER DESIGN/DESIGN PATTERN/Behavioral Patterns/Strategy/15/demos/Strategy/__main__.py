from strategy import Order, ShippingCost
from strategy import FedExStrategy, PostalStrategy, UPSStrategy

# Test Federal Express shipping

order = Order()
strategy = FedExStrategy()
cost_calulator = ShippingCost(strategy)
cost = cost_calulator.shipping_cost(order)
assert cost == 3.0

# Test UPS shipping

order = Order()
strategy = UPSStrategy()
cost_calulator = ShippingCost(strategy)
cost = cost_calulator.shipping_cost(order)
assert cost == 4.0

# Test Postal Service shipping

order = Order()
strategy = PostalStrategy()
cost_calulator = ShippingCost(strategy)
cost = cost_calulator.shipping_cost(order)
assert cost == 5.0

print('Tests passed')
