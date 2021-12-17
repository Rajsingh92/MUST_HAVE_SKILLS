#!/usr/bin/python
import sys
from datetime import datetime
import time

(prev_userid, prev_logtime, timeonsite) = (None, "", 0)
fmt = '%m/%d/%Y %H:%M:%S'
msg = "{0}\t{1}"
for line in sys.stdin:
        # get userid and logtime from input string by splitting on tab
        if "\t" not in line: continue
        userid, logtime = line.strip().split("\t")
        # is this a different user than the previous one?
        if prev_userid and prev_userid != userid:
                print(msg.format(prev_userid, timeonsite))
                (prev_userid, prev_logtime, timeonsite) = (userid, logtime, 0)
        else:
                if "/" not in logtime: continue
                current_d = datetime.strptime(logtime, fmt)
                prev_d = datetime.strptime(prev_logtime, fmt) if prev_logtime else current_d
                
                # convert to unix timestamp
                c_ts = time.mktime(current_d.timetuple())
                p_ts = time.mktime(prev_d.timetuple())
                
                timeonsite += int(c_ts - p_ts)
                
                (prev_userid, prev_logtime) = (userid, logtime)

if prev_userid:
        print(msg.format(prev_userid, timeonsite))
