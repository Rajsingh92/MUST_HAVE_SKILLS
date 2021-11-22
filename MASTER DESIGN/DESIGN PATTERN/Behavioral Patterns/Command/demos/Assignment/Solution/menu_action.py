from Queue import LifoQueue
from collections import defaultdict

class Actions(object):
    def __init__(self, activate, deactivate):
        self.activate = activate
        self.deactivate = deactivate

class MenuAction(object):
    def __init__(self):
        self.undo_commands = LifoQueue()
        self.commands = defaultdict(Actions)

    def set_command(self, item, activate, deactivate):
        self.commands[item] = Actions(activate, deactivate)

    def activate(self, item):
        action = self.commands[item].activate
        action.execute()
        self.undo_commands.put(action)

    def deactivate(self, item):
        action = self.commands[item].deactivate
        action.execute()
        self.undo_commands.put(action)

    def undo(self):
        if not self.undo_commands.empty():
            self.undo_commands.get().undo()
