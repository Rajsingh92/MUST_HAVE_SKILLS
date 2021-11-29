import math
import random
import time
import sys

class Event:
    x: int      # two-dimensional coordinates
    y: int      # 
    t: float    # time of event (nanoseconds)
    e: float    # energy level measured

    def __init__(self, x, y, t, e):
        self.x = x
        self.y = y
        self.t = t
        self.e = e

    def velocity(self):
        # Atlas Inner Detector: radius of 1.2 metres, and is 6.2  metres in length
        v = 10e9 * math.sqrt(1.2 ** 2 + math.sqrt(self.x ** 2 + self.y ** 2))  / self.t
        return v

def main():
    start = time.time_ns()
    time.sleep(1e-9)
    
    event_list = []
    for _ in range(100):
    # Atlas Inner Detector: radius of 1.2 metres, and is 6.2 metres in length
        x = math.floor(random.random() * 10)
        y = math.floor(random.random() * 10)
        t = time.time_ns() - start              # observation time since start
        e = random.random() * (1000)            # range of calorimeter in Kelvins
        event_list.append(Event(x, y, t, e))

    o = event_list[0]
    o_size = sys.getsizeof(o) + 4*8 + 4*8
    print(f'Event object size: {o_size} bytes')
    print(f'Particle velocity: {o.velocity()} meters/second')

    e = event_list
    print(f'Size of list: {sys.getsizeof(e)+ len(e) * o_size} bytes')

main()
