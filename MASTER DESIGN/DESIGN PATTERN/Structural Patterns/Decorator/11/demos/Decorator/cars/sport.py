from .abs_car import AbsCar

class Sport(AbsCar):
    @property
    def description(self):
        return 'Sport'

    @property
    def cost(self):
        return 15000.00
