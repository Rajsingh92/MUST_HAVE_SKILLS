from logger_base import Logger

logger = Logger('my.log')
logger.write_log('Logging with classic Singleton pattern')

logger2 = Logger('***ignored***')
assert logger is logger2
print('Assertion passed')

logger2.write_log('Another log record')
logger.close_log()
# logger2.close_log() # This will throw an exception

with open('my.log', 'r') as f:
    for line in f:
        print(line, end='')
