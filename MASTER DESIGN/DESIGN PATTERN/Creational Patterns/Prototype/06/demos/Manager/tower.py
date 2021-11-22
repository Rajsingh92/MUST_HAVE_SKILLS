from abs_prototype import AbsPrototype
from abs_computer import AbsComputer
import copy

class MainBoard(object):
    manufacturer: str
    model: str

    def __init__(self, manufacturer, model):
        self.manufacturer = manufacturer
        self.model = model

class Tower(AbsComputer, AbsPrototype):
    def __init__(self, model, mainboard, processor, memory, hard_drive, graphics, monitor):
        self.model = model
        self.mainboard = mainboard
        self.processor = processor
        self.memory = memory
        self.hard_drive = hard_drive
        self.graphics = graphics
        self.monitor = monitor

    def display(self):
        print('Custom Computer: ' + self.model)
        print('\t{:>10}: {}'.format('Mainboard', self.mainboard.model))
        print('\t{:>10}: {}'.format('Processor', self.processor))
        print('\t{:>10}: {}'.format('Memory', self.memory))
        print('\t{:>10}: {}'.format('Hard drive', self.hard_drive))
        print('\t{:>10}: {}'.format('Graphics', self.graphics))
        print('\t{:>10}: {}'.format('Monitor', self.monitor if self.monitor else 'None'))        

    def clone(self):
        return copy.deepcopy(self)
    