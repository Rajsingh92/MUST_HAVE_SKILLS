from myclass import MyClass

class MyObjectFactory:
    @staticmethod
    def create_object(value):
        if value == 'myclass':
            return MyClass()
