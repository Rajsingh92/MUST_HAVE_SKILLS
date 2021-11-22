from strategy_variation import Order, ShippingCost

def fedex_strategy(order):
    return 3.0

ups_strategy = lambda order: 4.0

order = Order()

# Test Federal Express shipping

strategy = fedex_strategy
cost_calulator = ShippingCost(strategy)
cost = cost_calulator.shipping_cost(order)
assert cost == 3.0

# Test UPS shipping

cost_calulator = ShippingCost(ups_strategy)
cost = cost_calulator.shipping_cost(order)
assert cost == 4.0

# Test Postal Service shipping

cost_calulator = ShippingCost(lambda order: 5.0)
cost = cost_calulator.shipping_cost(order)
assert cost == 5.0

print('Tests passed')