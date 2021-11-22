from .abs_handler import AbsHandler

class PetHandler(AbsHandler):
    
    def __init__(self):
        self._successors = []

    def add_successor(self, successor):
        self._successors.append(successor)

    def handle(self, request):
        for s in self._successors:
            if s.handle(request):
                break
