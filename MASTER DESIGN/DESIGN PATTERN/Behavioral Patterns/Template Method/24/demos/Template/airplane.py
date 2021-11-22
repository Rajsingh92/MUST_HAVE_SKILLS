from abs_transport import AbsTransport

class Airplane(AbsTransport):

    def start_engine(self):
        print('Starting the Rolls-Royce gas-turbine engines')

    def leave_terminal(self):
        print('Leaving terminal')
        print('Taxiing to runway')

    def travel_to_destination(self):
        print('Flying...')

    def entertainment(self):
        print('Playing in-flight movie')

    def arrive_at_destination(self):
        print(f'Landing at {self._destination}')
