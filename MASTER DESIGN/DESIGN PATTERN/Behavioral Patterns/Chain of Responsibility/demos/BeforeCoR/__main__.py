from dataclasses import dataclass
from handlers import walk_dogs, see_cats, clean_tank, check_life

@dataclass
class Request:
    request_type: str
    request_details: str

REQUESTS = [
    Request('dogs', 'walk twice a day'),
    Request('cats', 'see how pretty they are'),
    Request('fish', 'keep the tank clean'),
    Request('parrot','check for signs of life') 
]

def main():
    for r in REQUESTS:
        if r.request_type == 'dogs':
            walk_dogs(r)
        elif r.request_type == 'cats':
            see_cats(r)
        elif r.request_type == 'fish':
            clean_tank(r)
        elif r.request_type == 'parrot':
            check_life(r)
        else: print(f'Unknown request type: {r.request_type}')            
    pass

if __name__ == '__main__':
    main()
