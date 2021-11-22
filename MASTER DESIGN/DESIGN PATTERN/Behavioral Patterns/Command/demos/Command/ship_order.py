from command_abc import AbsCommand
from order_command_abc import AbsOrderCommand


class ShipOrder(AbsCommand, AbsOrderCommand):
    name = description = 'ShipOrder'

    def execute(self):
        raise NotImplementedError
