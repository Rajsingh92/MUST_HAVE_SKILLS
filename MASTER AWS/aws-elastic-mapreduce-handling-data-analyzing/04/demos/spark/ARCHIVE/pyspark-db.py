# Creates a DataFrame based on a table named "people"
# stored in a MySQL database.
url = \
  "jdbc:mysql://mysql-endpoint:3306/sparktest?user=dbuser;password=PASSWORD"
df = sqlContext \
  .read \
  .format("jdbc") \
  .option("url", url) \
  .option("dbtable", "test") \
  .load()

# Looks the schema of this DataFrame.
df.printSchema()

# Counts people by age
countsByAge = df.groupBy("age").count()
countsByAge.show()

# Saves countsByAge to S3 in the JSON format.
countsByAge.write.format("json").save("s3a://YOUR_S3_BUCKET/spark/output.json")
