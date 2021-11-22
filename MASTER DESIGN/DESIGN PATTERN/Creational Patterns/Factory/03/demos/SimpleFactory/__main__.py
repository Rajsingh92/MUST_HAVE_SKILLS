from autofactory import AutoFactory

factory = AutoFactory()

for carname in 'ChevyVolt', 'FordFusion', 'JeepSahara', 'Tesla Roadster':
    
    car = factory.create_instance(carname)
    car.start()
    car.stop()
