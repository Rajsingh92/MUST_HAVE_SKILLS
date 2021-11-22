from collections import Iterator

class Employees(Iterator):
    _employees = {}
    _headcount = 0
    _empid = 0

    def add_employee(self, employee):
        self._headcount += 1
        self._employees[self._headcount] = employee

    def __iter__(self):
        self._empid = 0
        return self

    def __next__(self):
        if self._empid < self._headcount:
            self._empid += 1
            return self._employees[self._empid]
        else:
            raise StopIteration
