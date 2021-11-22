from .pet_handler import PetHandler

class ParrotHandler(PetHandler):

    def handle(self, request):
        if request.request_type == 'parrot':
            print('I know a dead parrot when I see one.')
        else:
            super().handle(request)
