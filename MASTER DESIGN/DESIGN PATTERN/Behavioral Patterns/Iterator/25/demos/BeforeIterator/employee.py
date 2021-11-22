from dataclasses import dataclass
from datetime import datetime

@dataclass
class Employee(object):
    empid: int
    name: str
    hiredate: datetime
