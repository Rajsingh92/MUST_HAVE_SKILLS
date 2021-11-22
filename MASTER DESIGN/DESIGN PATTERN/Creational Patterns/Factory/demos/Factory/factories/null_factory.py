from .abs_factory import AbsFactory
from autos.nullcar import NullCar

class NullFactory(AbsFactory):

    def create_auto(self):
        self.nullcar = nullcar = NullCar()
        nullcar.name = 'Unknown'
        return nullcar
