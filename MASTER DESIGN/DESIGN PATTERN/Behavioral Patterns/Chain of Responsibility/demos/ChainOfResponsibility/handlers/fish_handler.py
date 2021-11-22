from .pet_handler import PetHandler

class FishHandler(PetHandler):

    def handle(self, request):
        if request.request_type == 'fish':
            print("I can't find Nemo!")
        else:
            super().handle(request)
