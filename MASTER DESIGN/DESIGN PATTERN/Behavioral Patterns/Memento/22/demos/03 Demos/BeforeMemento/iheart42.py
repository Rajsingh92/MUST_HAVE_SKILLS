from dataclasses import dataclass
from pickle import dumps, loads

@dataclass
class GameState:
    
    name: str
    level: int

class I_Heart_42:

    def __init__(self, name):
        self.game_state = GameState(name, 1)

    def save_game(self):
        self.oldstate = dumps(self.game_state)
        return self.oldstate
    
    def restore_game(self, state):
        self.game_state = loads(state)
