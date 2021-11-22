from cars.abs_car import AbsCar

class AbsDecorator(AbsCar):
    def __init__(self, car):
        self._car = car

    @property
    def car(self):
        return self._car

    @property
    def premium(self):
        return self.car.premium

