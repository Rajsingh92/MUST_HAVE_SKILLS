from collections import Iterable
from functools import reduce
from .abs_tree import AbsTree
from .null_person import NullPerson

class Tree(Iterable, AbsTree):

    def __init__(self, name, members):
        self._name = name
        self._members = members

    def __iter__(self):
        return iter(self._members)

    @property
    def name(self):
        return self._name

    def accept(self, visitor):
        visitor.visit_tree(self)
        for node in self:
            node.accept(visitor)
