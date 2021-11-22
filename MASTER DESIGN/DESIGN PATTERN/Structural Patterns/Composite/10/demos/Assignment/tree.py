from collections import Iterable
from functools import reduce
from datetime import date
from abs_composite import AbsComposite

class Tree(Iterable, AbsComposite):

    def __init__(self, members):
        self.members = members

    def __iter__(self):
        return iter(self.members)

    def get_oldest(self):
        def f(t1, t2):
            t1_, t2_ = t1.get_oldest(), t2.get_oldest()
            return t1_ if t1_.birthdate < t2_.birthdate else t2_
        return reduce(f, self, NullPerson())

    def distribute_inheritance(self, value):
        portion = value / len(self.members)
        for member in self.members:
            member.distribute_inheritance(portion)

class NullPerson(AbsComposite):
    name = None
    birthdate = date.max

    def get_oldest(self):
        return self
