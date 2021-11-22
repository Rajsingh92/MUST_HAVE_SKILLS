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

    def get_oldest(self):
        def f(t1, t2):
            t1_, t2_ = t1.get_oldest(), t2.get_oldest()
            return t1_ if t1_.birthdate < t2_.birthdate else t2_
        return reduce(f, self, NullPerson())

    def pretty_print(self):
        print(f'{self.name} members:')
        for node in self:
            node.pretty_print()
