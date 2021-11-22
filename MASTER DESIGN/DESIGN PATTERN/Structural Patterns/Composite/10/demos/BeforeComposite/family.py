from collections import Iterable

class Family(Iterable):
    _members = []

    def __init__(self, members):
        self._members = members

    def __iter__(self):
        return iter(self._members)
