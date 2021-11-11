from random import randint


class Dice:
    def __init__(self):
        self.number = None

    def get_number(self):
        return self.number

    def throw_dice(self):
        self.number = randint(1, 6)
        return self.number
