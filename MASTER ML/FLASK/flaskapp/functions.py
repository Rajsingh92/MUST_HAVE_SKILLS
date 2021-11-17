import os
import logging


def init_log(log_name):
    from logging.handlers import RotatingFileHandler
    # Logging Globals
    LOG_FORMAT = "%(asctime)s [%(levelname)s] %(message)s"
    log_dir = os.getcwd()+'/log'
    log_file = log_dir + '/' + log_name + '.log'

    if not os.path.exists(log_dir):
        os.makedirs(log_dir)

    global log
    log = logging.getLogger(log_name)
    handler = RotatingFileHandler(log_file, maxBytes=5000000, backupCount=3)
    formatter = logging.Formatter(LOG_FORMAT)
    handler.setFormatter(formatter)
    log.addHandler(handler)
    log.setLevel(logging.DEBUG)
    return log
