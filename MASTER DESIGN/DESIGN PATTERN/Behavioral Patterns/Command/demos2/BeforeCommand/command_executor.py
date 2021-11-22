class CommandExecutor(object):

    def execute_command(self, args):
        cmd, *parms = args
        if cmd == "CreateOrder":
            self.create_order()
        elif cmd == "UpdateQuantity":
            self.update_quantity(parms[0])
        elif cmd == "ShipOrder":
            self.ship_order()
        else:
            print (f'Unrecognized command: "{cmd}".')

    def create_order(self):
        raise NotImplementedError

    def update_quantity(self, val):
        old_val = 5
        print ('Database updated')
        print (f'Logging updated quantity from "{old_val}" to "{val}".')

    def ship_order(self):
        raise NotImplementedError
