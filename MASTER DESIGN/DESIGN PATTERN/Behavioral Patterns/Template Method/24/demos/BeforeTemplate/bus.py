class Bus(object):

    def __init__(self, destination):
        self._destination = destination

    def bus_trip(self):
        self.start_diesel()
        self.leave_terminal()
        self.drive_to_destination()
        self.arrive_at_destination()

    def start_diesel(self):
        print('Starting the Cummins diesel engine')

    def leave_terminal(self):
        print('Leaving terminal')

    def drive_to_destination(self):
        print('Driving...')

    def arrive_at_destination(self):
        print('Arriving at ' + self._destination)
