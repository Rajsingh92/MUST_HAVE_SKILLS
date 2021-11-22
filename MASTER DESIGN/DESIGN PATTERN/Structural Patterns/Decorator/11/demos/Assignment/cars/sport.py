from .abs_car import AbsCar

class Sport(AbsCar):
    @property
    def description(self):
        return 'Sport'

    @property
    def cost(self):
        return 15000.00

    @property
    def premium(self):
        return 1.50