class Door(object):
    def __init__(self, name):
        self.name = name

    def lock(self):
        print("%s is locked." % self.name)

    def unlock(self):
        print("%s is unlocked." % self.name)