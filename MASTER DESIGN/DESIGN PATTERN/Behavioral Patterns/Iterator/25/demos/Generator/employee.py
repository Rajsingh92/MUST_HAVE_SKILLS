from dataclasses import dataclass
from datetime import datetime

@dataclass
class Employee(object):
    number: int
    name: str
    date: datetime
