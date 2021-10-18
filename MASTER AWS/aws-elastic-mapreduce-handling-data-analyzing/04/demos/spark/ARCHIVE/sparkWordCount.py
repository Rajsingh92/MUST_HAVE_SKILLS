from pyspark import SparkContext
from datetime import datetime
import sys

if __name__ == “__main__”:
    if len(sys.argv) != 3:
        exit(-1)
    sc = SparkContext(appName=”SparkWords”)
    textfile = sc.textFile(sys.argv[1])
    occurences = textfile.flatMap(
                         lambda line: line.lower()
                                          .replace(“,”, “ “)
                                          .replace(“.”, “ “)
                                          .split(“ “))
                         .map(lambda word : (word, 1))
                         .reduceByKey(lambda a,b: a+b)
                         .map(lambda a: (a[1], a[0]))
                         .sortByKey(False)
    format_time = datetime.now().strftime(“%Y-%m-%dT%H:%M:%S”)
    occurences.saveAsTextFile(“{0}/{1}”.format(
                                        sys.argv[2], format_time))
    sc.stop()