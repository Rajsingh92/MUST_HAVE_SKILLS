from .abs_decorator import AbsDecorator

class Inline4Cyl(AbsDecorator):
    @property
    def description(self):
        return self.car.description + ', inline 4 cylinder'

    @property
    def cost(self):
        return self.car.cost + 500.00
