import random

class Cat:
    def __init__(self, name):
        self.name = name
    
    def wants_out(self):
        if self.fish.is_alive():
            print(f'let {self.name} in')
        else:
            print(f'let {self.name} out')

    def is_asleep(self):
        return random.randint(0,1)

class Dog:
    def __init__(self, name):
        self.name = name
    
    def wants_walk(self):
        if self.cat.is_asleep():
            print(f'walk {self.name}')

class Fish:
    def __init__(self, name):
        self.name = name
        
    def needs_food(self):
        print(f'feed {self.name}')

    def is_alive(self):
        return random.randint(0,1)
