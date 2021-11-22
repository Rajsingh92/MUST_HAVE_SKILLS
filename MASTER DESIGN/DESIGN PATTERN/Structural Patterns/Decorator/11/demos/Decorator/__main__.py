from cars.economy import Economy
from decorators.v6 import V6
from decorators.vinyl import Vinyl
from decorators.black import Black

def main():
    car = Economy()
    show(car)
    car = V6(car)
    show(car)
    car = Vinyl(car)
    show(car)
    car = Black(car)
    show(car)

def show(car):
    print(f'Description: {car.description}; cost: ${car.cost}')

if __name__ == '__main__':
    main()
