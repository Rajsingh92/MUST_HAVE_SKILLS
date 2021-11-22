from database import Database

class TestDatabase(Database):
    def __init__(self, name):
        super().__init__(name)

test = TestDatabase('test')
test2 = TestDatabase('test two')

class NewDatabase(Database):
    def __init__(self, name):
        super().__init__(name)

new = NewDatabase('new')
new2 = NewDatabase('new two')

test.query("SELECT 42 as 'The Answer'")
test2.query("SELECT 42 as 'six times seven'")
new.query("EXEC my_new_stored_procedure;")
new2.query("EXEC my_2nd_stored_procedure;")
test.close()
test2.close()
new.close()
new2.close()
