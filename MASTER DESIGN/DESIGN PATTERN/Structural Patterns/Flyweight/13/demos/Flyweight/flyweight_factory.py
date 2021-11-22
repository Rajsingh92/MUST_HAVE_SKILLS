from flyweight import SharedEvents

class FlyweightFactory:
    @staticmethod
    def get_flyweight(xaxis, yaxis):
        return SharedEvents(xaxis, yaxis)
