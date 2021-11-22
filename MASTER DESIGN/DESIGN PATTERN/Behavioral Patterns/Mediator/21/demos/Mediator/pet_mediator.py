class PetMediator:
    def __init__(self, cat, dog, fish):
        self.cat = cat
        self.dog = dog
        self.fish = fish

    def time_of_day(self, t):
        if t < 0:
            print('Morning:')
            self.morning = True
            self.cat.wants_out()
            self.fish.needs_food()
            self.dog.wants_walk()

        if t == 0:
            print('Noon:')
            self.morning = False
            self.cat.wants_out()   
            
        if t > 0:
            print('Night:')
            self.morning = False 
            self.cat.wants_out()
            self.dog.wants_walk() 

    def is_cat_asleep(self):
        return self.cat.is_asleep()

    def is_fish_alive(self):
        return self.fish.is_alive() 

    def is_morning(self):
        return self.morning     
    
    def wake_up_cat(self):
        self.cat.is_awake = 1
