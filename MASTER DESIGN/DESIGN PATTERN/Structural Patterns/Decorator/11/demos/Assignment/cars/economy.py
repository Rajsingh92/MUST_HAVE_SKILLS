from .abs_car import AbsCar

class Economy(AbsCar):
    @property
    def description(self):
        return 'Economy'

    @property
    def cost(self):
        return 12000.00

    @property
    def premium(self):
        return 1.00
