from importlib import import_module
from inspect import getmembers, isabstract, isclass
from .null_cust import NullCust
from .abs_cust import AbsCust

def load_cust(cust_type):
    try:
        cust_module = import_module('.' + cust_type, 'cust_objects')
    except ImportError:
        return NullCust(cust_type)
    
    classes = getmembers(cust_module, 
                        lambda m: isclass(m) and not isabstract(m))

    for name, _class in classes:
        if issubclass(_class, AbsCust):
            return _class()