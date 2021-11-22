import random
from .abs_pet import AbsPet

class Fish(AbsPet):
        
    def needs_food(self):
        if self.mediator.is_morning():
            print(f'Feed {self.name}')
        else:
            print(f"{self.name} isn't hungry")

    def is_alive(self):
        return random.randint(0,1)
