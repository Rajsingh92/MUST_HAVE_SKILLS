import abc

class AbsEmployees(abc.ABC):

    @abc.abstractmethod
    def get_employee_info(self, empids):
        pass
