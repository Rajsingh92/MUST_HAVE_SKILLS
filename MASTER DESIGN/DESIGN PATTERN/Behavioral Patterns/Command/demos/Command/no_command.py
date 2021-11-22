from command_abc import AbsCommand


class NoCommand(AbsCommand):
    def __init__(self, args):
        self._command = args[0]
        pass

    def execute(self):
        print('No command named %s' % self._command)




