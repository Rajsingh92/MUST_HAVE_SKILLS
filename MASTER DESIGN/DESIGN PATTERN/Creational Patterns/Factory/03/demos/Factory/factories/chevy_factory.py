from .abs_factory import AbsFactory
from autos.chevyvolt import ChevyVolt

class ChevyFactory(AbsFactory):

    def create_auto(self):
        self.chevy = chevy = ChevyVolt()
        chevy.name = 'Chevy Volt'
        return chevy
