import random
from .abs_pet import AbsPet

class Cat(AbsPet):
    is_awake = random.randint(0,1)
   
    def wants_out(self):
        if self.mediator.is_fish_alive():
            print(f'Let {self.name} in')
        else:
            print(f'Let {self.name} out')

    def is_asleep(self):
        return not self.is_awake
