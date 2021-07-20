/**
Logger Rate Limiter |  Easy | Facebook, Google |
each message should be printed if and only if it is not printed in the last 10 seconds.


// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true; 

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
 */


public class Logger {
    Map<String, Integer> map = new HashMap<>();
    int limiter = 10;

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            if (timestamp - map.get(message) >= limiter) {
                map.put(message, timestamp);
                return true;
            }
        }

        return false;
    }
}