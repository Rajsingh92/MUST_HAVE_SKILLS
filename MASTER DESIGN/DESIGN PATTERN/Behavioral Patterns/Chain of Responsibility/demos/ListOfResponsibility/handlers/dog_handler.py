from .pet_handler import PetHandler

class DogHandler():

    def handle(self, request):
        if request.request_type == 'dogs':
            print('Dogs love walks!')
            return True
