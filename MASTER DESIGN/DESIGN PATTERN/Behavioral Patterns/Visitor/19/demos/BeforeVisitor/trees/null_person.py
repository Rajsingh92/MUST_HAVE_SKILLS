from .abs_tree import AbsTree
from datetime import date

class NullPerson(AbsTree):
    
    name = None
    birthdate = date.max

    def get_oldest(self):
        return self

    def pretty_print(self):
        print (f'Nothing to see here. Move along!')
