from .pet_handler import PetHandler
from .cat_handler import CatHandler
from .dog_handler import DogHandler
from .fish_handler import FishHandler
from .parrot_handler import ParrotHandler

handler_chain = PetHandler(None)
for handler in CatHandler, DogHandler, FishHandler, ParrotHandler:
    new_handler = handler(handler_chain)
    handler_chain = new_handler
