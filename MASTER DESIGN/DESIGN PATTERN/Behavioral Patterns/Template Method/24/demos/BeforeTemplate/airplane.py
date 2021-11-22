class Airplane(object):

    def __init__(self, destination):
        self._destination = destination

    def plane_trip(self):
        self.start_gas_turbines()
        self.leave_terminal()
        self.fly_to_destination()
        self.land_at_destination()
        
    def start_gas_turbines(self):
        print('Starting the Rolls-Royce gas-turbine engines')

    def leave_terminal(self):
        print('Taxiing to the runway')
        print('Taking off')

    def fly_to_destination(self):
        print('Flying...')

    def land_at_destination(self):
        print('Landing at ' + self._destination)
