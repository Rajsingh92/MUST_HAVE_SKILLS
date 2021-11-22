from .command_abc import AbsCommand
from .order_command_abc import AbsOrderCommand


class UpdateOrder(AbsCommand, AbsOrderCommand):
    name = 'UpdateQuantity'
    description = 'UpdateQuantity number'

    def __init__(self, args):
        self.newqty = args[1]

    def execute(self):
        oldqty = 5
        # Simulate database update
        print('Updated Database')

        # Simulate logging the update
        print(f'Logging: Updated quantity from "{oldqty}" to "{self.newqty}"')
