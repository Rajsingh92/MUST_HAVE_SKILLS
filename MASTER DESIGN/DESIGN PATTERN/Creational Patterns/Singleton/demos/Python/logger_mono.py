import datetime
from monostate import MonoState

class Logger(MonoState):
    log_file = None

    def __init__(self, path):
        if self.log_file is None:
            self.log_file = open(path,mode='w')

    def write_log(self, log_record):
        now = str(datetime.datetime.now())
        record = '%s: %s\n' % (now, log_record)
        self.log_file.write(record)

    def close_log(self):
        self.log_file.close() 
        self.log_file = None       
