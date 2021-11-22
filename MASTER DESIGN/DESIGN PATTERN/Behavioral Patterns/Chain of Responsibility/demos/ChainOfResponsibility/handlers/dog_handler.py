from .pet_handler import PetHandler

class DogHandler(PetHandler):

    def handle(self, request):
        if request.request_type == 'dogs':
            print('Dogs love walks!')
        else:
            super().handle(request)
