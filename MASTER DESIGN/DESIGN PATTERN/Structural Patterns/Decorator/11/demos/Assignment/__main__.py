from cars.luxury import Luxury
from decorators.v6 import V6
from decorators.vinyl import Vinyl
from decorators.black import Black

def main():
    car = Luxury()
    show(car)
    car = V6(car)
    show(car)
    car = Vinyl(car)
    show(car)
    car = Black(car)
    show(car)

def show(car):
    print('Description: {}; cost: ${}'.format(car.description, car.cost))

if __name__ == '__main__':
    main()
