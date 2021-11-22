from .abs_car import AbsCar

class Economy(AbsCar):
    def __init__(self, engine, paint, upholstery):
        self._engine = engine
        self._paint = paint
        self._upholstery = upholstery

    @property
    def description(self):
        return 'Economy'

    @property
    def engine(self):
        return self._engine

    @property
    def paint(self):
        return self._paint

    @property
    def upholstery(self):
        return self._upholstery

    @property
    def cost(self):
        return 12000.00 + super().cost()
