from abs_transport import AbsTransport

class Bus(AbsTransport):

    def start_engine(self):
        print('Starting the Cummins diesel engine')

    def travel_to_destination(self):
        print('Driving...')
