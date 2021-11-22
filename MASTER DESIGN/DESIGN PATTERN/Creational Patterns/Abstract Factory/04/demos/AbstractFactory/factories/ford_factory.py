from .abs_factory import AbsFactory
from autos.ford.fiesta import FordFiesta
from autos.ford.mustang import FordMustang
from autos.ford.lincoln import LincolnMKS

class FordFactory(AbsFactory):
    @staticmethod
    def create_economy():
        return FordFiesta()

    @staticmethod
    def create_sport():
        return FordMustang()

    @staticmethod
    def create_luxury():
        return LincolnMKS()
