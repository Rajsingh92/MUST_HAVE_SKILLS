from pyspark.sql import SparkSession
from pyspark.sql.types import IntegerType, StringType, StructType, StructField

# create spark session
spark = SparkSession.builder.appName('Convert Table to DataFrame').getOrCreate()

# create schema for dataframe
schema = StructType([
    StructField('customer_id', IntegerType(), True),
    StructField('customer_name', StringType(), True)
])

# create data for dataframe
data = [
    (1, 'Alice'),
    (4, 'Bob'),
    (5, 'Charlie')
]

# create dataframe
df = spark.createDataFrame(data, schema)

# show dataframe
df.show()
