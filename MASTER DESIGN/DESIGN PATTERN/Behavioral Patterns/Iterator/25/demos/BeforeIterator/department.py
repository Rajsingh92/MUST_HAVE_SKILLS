from dataclasses import dataclass
from datetime import datetime

@dataclass
class Department:
    deptid: str
    name: int
    date_established: datetime 
