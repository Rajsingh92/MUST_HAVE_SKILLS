from .abs_tree import AbsTree
from datetime import date

class NullPerson(AbsTree):
    
    name = None
    birthdate = date.max

    def accept(self, visitor):
        visitor.visit_person(self)
