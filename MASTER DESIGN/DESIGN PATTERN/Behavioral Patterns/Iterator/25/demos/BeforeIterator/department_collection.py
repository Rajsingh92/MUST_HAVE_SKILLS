class Departments(object):
    _departments = []

    def add_department(self, department):
        self._departments.append(department)

    def get_department(self, i):
        return self._departments[i]

    @property
    def departments_range(self):
        return (0, len(self._departments) - 1)
