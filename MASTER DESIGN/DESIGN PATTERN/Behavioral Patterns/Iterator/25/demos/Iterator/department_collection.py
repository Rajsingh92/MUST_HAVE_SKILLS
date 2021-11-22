from collections import Sequence

class Departments(Sequence):
    _departments = []

    def add_department(self, department):
        self._departments.append(department)

    def __getitem__(self, item):
        return self._departments[item]

    def __len__(self):
        return len(self._departments)
