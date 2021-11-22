from .abs_decorator import AbsDecorator

class V6(AbsDecorator):
    @property
    def description(self):
        return self.car.description + ', top-grain leather'

    @property
    def cost(self):
        return self.car.cost + 2700.00*self.car.premium
