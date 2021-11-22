import math
import random
import time
import sys
from flyweight_factory import FlyweightFactory

def main():
    events = FlyweightFactory.get_flyweight(10,10) # z-axis is 2
    start = time.time_ns()
    events.set_event(1,2,3,4)
    time.sleep(1e-9)

    for _ in range(100):
        x = math.floor(random.random() * 10)
        y = math.floor(random.random() * 10)      
        t = time.time_ns() - start              
        e = random.random() * (1000)   
        events.set_event(x, y, t, e)

    o = events.get_event(0,0)
    print(f'Event object size: {2 * 8} bytes')
    print(f'Particle velocity: {events.get_velocity(1,2)} meters/second')

    e = events._events
    print(f'Size of array: {2 * 8 * 10 * 10} bytes')

if __name__ == "__main__":
    main()
