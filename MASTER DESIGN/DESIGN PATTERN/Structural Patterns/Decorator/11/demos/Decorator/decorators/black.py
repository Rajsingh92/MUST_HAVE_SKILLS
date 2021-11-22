from .abs_decorator import AbsDecorator

class Black(AbsDecorator):
    @property
    def description(self):
        return self.car.description + ', midnight black'

    @property
    def cost(self):
        return self.car.cost + 1800.00
