from actions.door import Door
from command_abc import AbsCommand


class DoorLockCommand(AbsCommand):
    def __init__(self, door):
        if not isinstance(door, Door):
            raise TypeError(f'Expected a Door object, got {door.__class__.__name__} instead.')
        self.door = door

    def execute(self):
        self.door.lock()

    def undo(self):
        self.door.unlock()


class DoorUnlockCommand(AbsCommand):
    def __init__(self, door):
        if not isinstance(door, Door):
            raise TypeError(f'Expected a Door object, got {door.__class__.__name__} instead.')
        self.door = door

    def execute(self):
        self.door.unlock()

    def undo(self):
        self.door.lock()