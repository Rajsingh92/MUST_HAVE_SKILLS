from .abs_decorator import AbsDecorator

class Vinyl(AbsDecorator):
    @property
    def description(self):
        return self.car.description + ', vinyl upholstery'

    @property
    def cost(self):
        return self.car.cost + 500.00
