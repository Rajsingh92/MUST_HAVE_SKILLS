from .abs_tree import AbsTree

class Person(AbsTree):

    def __init__(self, name, birthdate):
        self._name = name
        self._birthdate = birthdate

    def get_oldest(self):
        return self
    
    @property
    def name(self):
        return self._name

    @property
    def birthdate(self):
        return self._birthdate
     
    def pretty_print(self):
        print (f'{self.name} was born on {self.birthdate}')
