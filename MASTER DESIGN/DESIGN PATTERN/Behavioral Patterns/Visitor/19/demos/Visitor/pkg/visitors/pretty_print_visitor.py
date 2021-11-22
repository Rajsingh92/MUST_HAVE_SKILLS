from .abs_visitor import Visitor

class PrettyPrintVisitor(Visitor):
    
    def visit_person(self, person):
        print (f'{person.name} was born on {person.birthdate}')

    def visit_tree(self, tree):
        print(f'{tree.name} members:')
