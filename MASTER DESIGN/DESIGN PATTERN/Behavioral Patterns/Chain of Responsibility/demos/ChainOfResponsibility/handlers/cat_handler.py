from .pet_handler import PetHandler

class CatHandler(PetHandler):

    def handle(self, request):
        if request.request_type == 'cats':
            print('People have dogs, cats have staff.')
        else:
            super().handle(request)
