from monostate_meta import MonoState

class Database(metaclass=MonoState):
    database = None

    def __init__(self, name):
        if self.database is None:
            self.database = name
        print ('Opening connection to database: ' + self.database)

    def query(self, qry):
        print ('Executing query on database: ' + self.database)
        print('    ' + qry)
    
    def close(self):
        if self.database is not None:
            print ('Closing connection to database: ' + self.database)
        self.database = None