from factories import loader

for factory_name in 'chevy_factory', 'jeep_factory', 'ford_factory', 'tesla_factory':

    factory = loader.load_factory(factory_name)
    car = factory.create_auto()

    car.start()
    car.stop()
