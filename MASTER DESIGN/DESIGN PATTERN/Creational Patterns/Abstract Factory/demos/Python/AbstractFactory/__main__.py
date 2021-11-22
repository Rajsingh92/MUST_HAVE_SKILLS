from factories.ford_factory import FordFactory
from factories.gm_factory import GMFactory

for factory in FordFactory, GMFactory:
    car = factory.create_economy()
    car.start()
    car.stop()
    car = factory.create_sport()
    car.start()
    car.stop()
    car = factory.create_luxury()
    car.start()
    car.stop()
