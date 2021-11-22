from .pet_handler import PetHandler

class FishHandler():

    def handle(self, request):
        if request.request_type == 'fish':
            print("I can't find Nemo!")
            return True
