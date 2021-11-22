import sys
from command_executor import CommandExecutor


if len(sys.argv) < 2:
    print 'Usage: C:\Python27\python -m BeforeCommand <command>'
    print 'Commands:'
    print '    CreateOrder'
    print '    UpdateQuantity number'
    print '    ShipOrder'
    exit()

executor = CommandExecutor()
executor.execute_command(sys.argv[1:])
