from datetime import date
from dateutil.relativedelta import relativedelta
from pkg.trees.person import Person
from pkg.trees.tree import Tree
from pkg.visitors.pretty_print_visitor import PrettyPrintVisitor
from pkg.visitors.get_oldest_visitor import GetOldestVisitor

# p = Person('Douglas', date(1952, 3, 11))
# v = PrettyPrintVisitor()
# p.accept(v)

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

ov = GetOldestVisitor()
tree3.accept(ov)
name, age = ov.oldest.name, relativedelta(date.today(),ov.oldest.birthdate)
print(f'Oldest person in tree {tree3.name}: {name}; Age: {age.years} years, {age.months} months')
