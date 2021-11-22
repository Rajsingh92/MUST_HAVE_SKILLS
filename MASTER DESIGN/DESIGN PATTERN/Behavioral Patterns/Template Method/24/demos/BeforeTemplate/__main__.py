from bus import Bus
from airplane import Airplane

def main():
    takebus('New York')
    takeplane('Amsterdam')

def takebus(destination):
    print(f'\nTaking the bus to {destination} =====>')
    bus = Bus(destination)
    bus.bus_trip()

def takeplane(destination):
    print(f'\nFlying to {destination} =====>')
    plane = Airplane(destination)
    plane.plane_trip()

if __name__ == '__main__':
    main()
