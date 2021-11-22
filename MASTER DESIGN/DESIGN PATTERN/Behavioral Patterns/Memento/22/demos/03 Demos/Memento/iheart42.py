# Originator
from memento import Memento
from dataclasses import dataclass
from pickle import dumps, loads

@dataclass
class GameState:
    name: str
    level: int

class I_Heart_42:

    def __init__(self, name):
        self.game_state = GameState(name, 1)

    def create_memento(self):
        memento = Memento()
        memento.set_state(self.game_state)
        return memento
    
    def set_memento(self, memento):
        self.game_state = memento.get_state()
