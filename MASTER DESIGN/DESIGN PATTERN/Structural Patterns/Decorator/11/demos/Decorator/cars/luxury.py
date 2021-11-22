from .abs_car import AbsCar

class Luxury(AbsCar):
    @property
    def description(self):
        return 'Luxury'

    @property
    def cost(self):
        return 18000.00
