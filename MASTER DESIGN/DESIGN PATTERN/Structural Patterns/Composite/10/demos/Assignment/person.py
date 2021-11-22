from abs_composite import AbsComposite

class Person(AbsComposite):

    def __init__(self, name, birthdate):
        self.name = name
        self.birthdate = birthdate

    def get_oldest(self):
        return self

    def distribute_inheritance(self, value):
        print('{} receives {:6.2f}'.format(self.name, value))
