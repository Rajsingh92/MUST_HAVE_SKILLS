from autos.abs_auto import AbsAuto

class FordMustang(AbsAuto):
    def start(self):
        print("Ford Mustang roaring and ready to go!")
    def stop(self):
        print('Ford Mustang shutting down.')
