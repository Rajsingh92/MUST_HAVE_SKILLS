from .abs_factory import AbsFactory
from autos.fordfocus import FordFocus

class FordFactory(AbsFactory):

    def create_auto(self):
        self.ford = ford = FordFocus()
        ford.name = 'Ford Focus'
        return ford
