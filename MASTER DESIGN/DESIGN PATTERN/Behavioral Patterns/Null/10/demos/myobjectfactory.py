from myclass import MyClass
from nullclass import NullClass

class MyObjectFactory:
    @staticmethod
    def create_object(value):
        if value == 'myclass':
            return MyClass()
        else:
            return NullClass()
