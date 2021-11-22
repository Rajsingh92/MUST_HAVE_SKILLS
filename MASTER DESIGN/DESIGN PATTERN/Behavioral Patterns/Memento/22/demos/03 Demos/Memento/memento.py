from pickle import dumps, loads

class Memento:

    def set_state(self, state):
        self._caretaker = dumps(state)

    def get_state(self):
        return loads(self._caretaker)
