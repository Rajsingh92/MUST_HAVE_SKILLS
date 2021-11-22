from datetime import date
from dateutil.relativedelta import relativedelta
from trees.person import Person
from trees.tree import Tree

def main():
    hitchhikers = Tree('Cast',[
        Person('Trillian', date(1970, 3, 14)),
        Person('Arthur', date(1965, 7, 4)),
        Person('Ford', date(1995, 2, 2)),
        Person('Zaphod', date(1997, 5, 1)),
    ])

    singles = Tree('Characters', [
        Person('Marvin', date(1991, 1, 1)),
        Person('Slarti', date(1993, 9, 9))
    ])

    loner = Person('Douglas', date(1952, 3, 11))

    tree1 = Tree('Cast', [hitchhikers])
    tree2 = Tree('Others', [singles, loner])
    tree3 = Tree('Everyone', [tree1, tree2])

    for tree in tree1, tree2, tree3:
        oldest = tree.get_oldest()
        age = relativedelta(date.today(),oldest.birthdate)
        print(f'Oldest person in tree {tree.name}: {oldest.name}; Age: {age.years} years, {age.months} months')

    for tree in tree1, tree2, tree3:
        tree.pretty_print()

if __name__ == '__main__':
    main()
