from .abs_auto import AbsAuto

class NullCar(AbsAuto):
    def __init__(self, carname):
        self._carname = carname

    def start(self):
        print('Unknown car "%s".' % self._carname)

    def stop(self):
        pass
