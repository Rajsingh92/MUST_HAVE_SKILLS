from abs_computer import AbsComputer
from abs_prototype import AbsPrototype
import copy

class Laptop(AbsComputer, AbsPrototype):
    def __init__(self, model, processor, memory, hard_drive, graphics, screen):
        self.model = model
        self.processor = processor
        self.memory = memory
        self.hard_drive = hard_drive
        self.graphics = graphics
        self.screen = screen

    def display(self):
        print('Custom Computer: ' + self.model)
        print('\t{:>10}: {}'.format('Processor', self.processor))
        print('\t{:>10}: {}'.format('Memory', self.memory))
        print('\t{:>10}: {}'.format('Hard drive', self.hard_drive))
        print('\t{:>10}: {}'.format('Graphics', self.graphics))
        print('\t{:>10}: {}'.format('Screen', self.screen))   

    def clone(self):
        return copy.copy(self)
