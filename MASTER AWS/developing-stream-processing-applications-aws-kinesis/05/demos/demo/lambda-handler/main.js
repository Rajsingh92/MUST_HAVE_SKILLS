'use strict';
var AWS = require('aws-sdk');
var agg = require('aws-kinesis-agg');

console.log('Loading function');

exports.handler = (event, context, callback) => {

    var cloudwatch = new AWS.CloudWatch();

    console.log('Processing records: ', event.Records.length);
    console.log('Received event:', JSON.stringify(event, null, 2));

    event.Records.forEach((record) => {
        console.log('Processing records: ', record.kinesis.sequenceNumber);

        // Deggregating KPL records
        agg.deaggregateSync(record.kinesis, true, (err, userRecords) => {
            console.log('Deaggregating records: ' + userRecords.length);
            if (err) {
                console.log(err);
                callback(err)
                return;
            }

            // Iterate over tweets
            userRecords.forEach((record) => {
                // Get serialized tweet
                var tweetData = new Buffer(record.data, 'base64');
                // Parse a tweet
                var tweet = JSON.parse(tweetData.toString('ascii'))

                console.log('Processing tweet:', tweet)
                console.log('Tweet created at: ', tweet.created_at);
                // Store value 1.0 for each tweet created
                var params = {
                    MetricData: [
                        {
                            MetricName: 'tweets-count',
                            Timestamp: tweet.timestamp_ms / 1000,
                            Unit: "None",
                            Value: 1.0
                        }
                    ],
                    Namespace: 'pluralsight-kinesis'
                };

                // Write data to CloudWatch
                cloudwatch.putMetricData(params, function(err, data) {
                    if (err) {
                        console.log(err, err.stack);
                        callback(err);
                    }
                });
            });
        });
    });
    callback(null, `Successfully processed ${event.Records.length} records.`);
};
