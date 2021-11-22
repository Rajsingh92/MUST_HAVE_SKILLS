import random
import time

from pets import Cat, Dog, Fish
from times import morning, noon, night

def main():
    cat = Cat('Cheshire')
    dog = Dog('Tramp')
    fish = Fish('Nemo')

    cat.dog = dog
    dog.cat = cat
    cat.fish = fish

    time.sleep(random.random())

    option = random.randint(-1, 1)
    if option < 0:
        morning(cat, dog, fish)
    if option == 0:
        noon(cat, dog, fish)
    if option > 0:
        night(cat, dog, fish)

if __name__ == '__main__':
    main()
