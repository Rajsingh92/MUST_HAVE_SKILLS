from autos.abs_auto import AbsAuto

class ChevyCamaro(AbsAuto):
    def start(self):
        print('Chevy Camaro V8 sounding awesome!')
    def stop(self):
        print('Chevy Camaro shutting down.')
