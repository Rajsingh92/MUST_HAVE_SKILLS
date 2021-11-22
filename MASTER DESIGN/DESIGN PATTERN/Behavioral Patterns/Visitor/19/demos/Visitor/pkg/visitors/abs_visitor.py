import abc

class Visitor(abc.ABC):

    @abc.abstractmethod
    def visit_person(self, person):
        pass

    @abc.abstractmethod
    def visit_tree(self, tree):
        pass
   