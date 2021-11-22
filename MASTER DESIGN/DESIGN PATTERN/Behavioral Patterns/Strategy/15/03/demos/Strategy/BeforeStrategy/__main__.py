from before_strategy import Order, Shipper, ShippingCost

# Test Federal Express shipping

order = Order(Shipper.fedex)
cost_calulator = ShippingCost()
cost = cost_calulator.shipping_cost(order)
assert cost == 3.0

# Test UPS shipping

order = Order(Shipper.ups)
cost_calulator = ShippingCost()
cost = cost_calulator.shipping_cost(order)
assert cost == 4.0

# Test Postal Service shipping

order = Order(Shipper.postal)
cost_calulator = ShippingCost()
cost = cost_calulator.shipping_cost(order)
assert cost == 5.0

print('Tests passed')