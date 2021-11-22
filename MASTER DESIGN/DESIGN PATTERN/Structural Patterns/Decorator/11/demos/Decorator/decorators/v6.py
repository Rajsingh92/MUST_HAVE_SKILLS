from .abs_decorator import AbsDecorator

class V6(AbsDecorator):
    @property
    def description(self):
        return self.car.description + ', V6'

    @property
    def cost(self):
        return self.car.cost + 1200.00
