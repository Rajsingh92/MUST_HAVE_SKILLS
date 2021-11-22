from .abs_factory import AbsFactory
from autos.fordfusion import FordFusion

class FordFactory(AbsFactory):

    def create_auto(self):
        self.ford = ford = FordFusion()
        ford.name = 'Ford Fusion'
        return ford
