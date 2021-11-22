from bus import Bus
from airplane import Airplane

def main():
    travel('New York', Bus)
    travel('Amsterdam', Airplane)

def travel(destination, transport):
    print(f'\nTaking the {transport.__name__} to {destination} =====>')

    means = transport(destination)
    means.take_trip()

if __name__ == '__main__':
    main()
