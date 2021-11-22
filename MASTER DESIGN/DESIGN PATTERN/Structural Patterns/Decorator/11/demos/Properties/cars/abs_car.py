import abc

class AbsCar(abc.ABC):
    @abc.abstractproperty
    def description(self):
        pass

    @abc.abstractproperty
    def engine(self):
        pass

    @abc.abstractproperty
    def paint(self):
        pass

    @abc.abstractproperty
    def upholstery(self):
        pass

    def cost(self):
        cost = 0.00
        if self.engine == '4 cyl':
            cost += 0.00
        elif self.engine == '6 cyl':
            cost += 1500.00
        if self.paint == 'white':
            cost += 0.00
        elif self.paint == 'black':
            cost += 1000.00
        elif self.paint == 'red':
            cost += 2000.00
        if self.upholstery == 'vinyl':
            cost += 0.00
        elif self.upholstery == 'leather':
            cost += 2000.00
        return cost
