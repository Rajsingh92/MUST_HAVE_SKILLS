from collections import namedtuple
from itertools import starmap

data = (('new', 10), ('open', 20), ('closed',30))
nt = namedtuple('KPI', 'name value')
KPI_Data = starmap(nt, data)