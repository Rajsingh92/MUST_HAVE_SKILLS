from abs_class import AbsClass

class NullClass(AbsClass):
    def do_something(self, value):
        print('Not doing %s.' % value)