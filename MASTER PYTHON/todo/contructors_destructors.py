# Default constructor
# Parameterized constructor


# Destructors are called when an object gets destroyed. In Python, destructors are not needed as much
# needed in C++ because Python has a garbage collector that handles memory management automatically.
# It is called when all references to the object have been deleted i.e when an object is garbage collected.

class Check:
    def __init__(self, a=None, b=None):
        self.a = a
        self.b = b

    def sum_(self):
        return self.a + self.b


if __name__ == "__main__":
    c = Check(3, 2)
    print(c.sum_())
