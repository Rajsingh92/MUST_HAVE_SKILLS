from .economy import Economy

class Economy4CylWhiteVinyl(Economy):
    @property
    def description(self):
        return 'Economy, white, 4 cylinder, vinyl upholstery'

    @property
    def cost(self):
        return 12000.00
