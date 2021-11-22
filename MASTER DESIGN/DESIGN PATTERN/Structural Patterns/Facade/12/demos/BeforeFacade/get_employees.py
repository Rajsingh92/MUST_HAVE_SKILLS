import pyodbc

CONNSTR = (
    'DRIVER={SQL Server};' +
    'SERVER=.\\sql2019;' +
    'DATABASE=AdventureWorks;' +
    'TRUSTED_CONNECTION=TRUE'
)

def get_employees():
    connection = pyodbc.connect(CONNSTR)
    query = '''
        SELECT DISTINCT TOP 5 FirstName, LastName 
        FROM Person.Person
        ORDER BY LastName, FirstName;
    '''
    cursor = connection.cursor()
    cursor.execute(query)
    for row in cursor:
        print(row.FirstName, row.LastName)
    connection.commit()
    connection.close()

get_employees()
