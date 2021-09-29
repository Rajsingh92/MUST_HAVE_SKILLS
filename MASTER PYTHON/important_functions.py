def abs_():
    print(abs(-2))
    print(abs(-2.3))
    print(abs(3-4j))


def round_():
    # floor if <5  , ceil if >=5
    print(round(2.3456))
    print(round(2.3456, 2))
    print(round(2.676, 2))


def maxmin_():
    print(max(1, 2, 3), min(1, 2, 3))
    print(max([1, 2, 3, 4]), min([1, 2, 3, 4]))
    # lexicographically maximum/minimum string
    print(max(["raj", "singh", "raj", "poot"]), min(["raj", "singh", "raj", "poot"]))
    # longest/Smallest string
    print(max(["raj", "singh", "raj", "poot"], key=len), min(["raj", "singh", "raj", "poot"], key=len))
    print(max("abbcccd"), min("abbcccd"))  # lexicographically maximum character


def sum_():
    print(sum((1, 2, 3)))
    print(sum((1, 2, 3), 2))  # 2 + (1,2,3)


def frozenset_():
    s = {1, 2, 3}
    ns = frozenset(s)  # returns an unchangeable frozenset object
    print(ns)


# The enumerate() function adds a counter as the key of the enumerate object.
def enumerate_():
    print(list(enumerate(("a", "b", "c", "d", "a"))))
    print(list(enumerate("abc")))
    print(list(enumerate("abc", 3)))

    for index, char in enumerate("abc"):
        print(str(index)+" -> "+char)


def sorted_():
    # Original list not modified
    print(sorted([3, 5, 2]))
    print(sorted([3, 5, 2], reverse=True))

    # List/Tuple/Set/Frozenset/String
    x = ['q', 'w', 'r', 'e', 't', 'y']
    print(sorted(x))

    # Dictionary
    x = {'q': 1, 'w': 2, 'e': 3, 'r': 4, 't': 5, 'y': 6}
    print(sorted(x))

    def func(num):
        return num % 7

    print(sorted([15, 3, 11, 7], key=func))
    print(sorted(["cccc", "b", "dd", "aaa"], key=len))


def pow_():
    print(pow(2, 3))
    print(pow(2, -1))
    print(pow(-2, 3))


if __name__ == "__main__":
    pow_()
