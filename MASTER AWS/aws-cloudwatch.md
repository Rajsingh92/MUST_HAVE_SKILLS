# AWS CloudWatch

* AWS CloudWatch monitors AWS resources and applications in real-time.
* CloudWatch can be used to collect and track metrics, which are the variables to be measured for resources and applications.
* CloudWatch alarms can be configured
  * to send notifications or
  * to automatically make changes to the resources based on defined rules
* In addition to monitoring the built-in metrics that come with AWS, custom metrics can also be monitored
* CloudWatch provides system-wide visibility into resource utilization, application performance, and operational health.
* By default,
  **CloudWatch stores the log data indefinitely**
  , and the retention can be changed for each log group at any time
* CloudWatch Alarm history is stored for only 14 days

#### Required Mainly for SysOps Associate & DevOps Professional Exam

## CloudWatch Architecture

![](https://i2.wp.com/docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/images/CW-Overview.png?zoom=1.25&resize=604%2C385&ssl=1 "CloudWatch Architecture")

* CloudWatch collects various metrics from various resources
* These metrics, as statistics, are available to the user through Console, CLI
* CloudWatch allows creation of alarms with defined rules
  * to perform actions to auto scaling or stop, start, or terminate instances
  * to send notifications using SNS actions on your behalf

## CloudWatch Concepts

### Metrics

* Metric is the fundamental concept in CloudWatch.
* Uniquely defined by a name, a namespace, and one or more dimensions
* Represents a time-ordered set of data points published to CloudWatch.
* Each data point has a time stamp, and \(optionally\) a unit of measure
* Data points can be either custom metrics or metrics from other
 
  services in AWS.
* Statistics can be retrieved about those data points as an ordered set of time-series data that occur within a specified time window.
* When the statistics are requested, the returned data stream is identified by namespace, metric name, dimension, and \(optionally\) the unit.
* Metrics exist only in the region in which they are created
* CloudWatch stores the metric data for two weeks
* Metrics cannot be deleted, but they automatically expire in 14 days if no new data is published to them.
* **NOTE: From**
  [**Nov 2016 AWS provides Extended Metrics Retention**](https://aws.amazon.com/blogs/aws/amazon-cloudwatch-update-extended-metrics-retention-user-interface-update/)
  * One minute data points are available for 15 days.
  * Five minute data points are available for 63 days.
  * One hour data points are available for 455 days \(15 months\).

### Namespaces

* CloudWatch namespaces are containers for metrics.
* Metrics in different namespaces are isolated from each other, so that metrics from different applications are not mistakenly aggregated into the same statistics.
* AWS namespaces all follow the convention AWS/&lt;service&gt;,_for e.g. AWS/EC2 and AWS/ELB_
* Namespace names must be fewer than 256 characters in length.
* **There is no default namespace. Each data element put into CloudWatch must specify a namespace**

### Dimensions

* A dimension is a name/value pair that uniquely identifies a metric.
* Every metric has specific characteristics that describe it, and you can think of dimensions as categories for those characteristics.
* Dimensions helps design a structure for the statistics plan.
* Dimensions are part of the unique identifier for a metric, whenever a unique name pair is added to one of the metrics, a new metric is created
* Dimensions can be used to filter result sets that CloudWatch query returns
* A metric can be assigned up to ten dimensions to a metric.

### Time Stamps

* Each metric data point must be marked with a time stamp to identify the data point on a time series
* Time stamp can be up to two weeks in the past and up to two hours into the future.
* If no time stamp is provided, CloudWatch creates a time stamp based on the time the data element was received.
* All times reflect the UTC time zone when statistics are retrieved

### Units

* Units represent the statistic’s unit of measure _for e.g. count, bytes, % etc_

### Statistics

* Statistics are metric data aggregations over specified periods of time
* Aggregations are made using the namespace, metric name, dimensions, and the data point unit of measure, within the specified time period

### Periods

* Period is the length of time associated with a specific statistic.
* Each statistic represents an aggregation of the metrics data collected for a specified period of time.
* Although periods are expressed in seconds, the minimum granularity for a period is one minute.

### Aggregation

* CloudWatch aggregates statistics according to the period length specified in calls to _GetMetricStatistics_
  .
* Multiple data points can be published with the same or similar time stamps. CloudWatch aggregates them by period length when the statistics about those data points are requested.
* Aggregated statistics are only available when using detailed monitoring.
* Instances that use basic monitoring are not included in the aggregates
* **CloudWatch does not aggregate data across regions.**

### Alarms

* Alarms can automatically initiate actions on behalf of the user, based on specified parameters
* Alarm watches a single metric over a specified time period, and performs one or more actions based on the value of the metric relative to a given threshold over a number of time periods.
* Alarms invoke actions for sustained state changes only i.e. the state must have changed and been maintained for a specified number of periods
* Action can be a
  * SNS notification
  * Auto Scaling policies
  * EC2 action – stop or terminate EC2 instances
* After an alarm invokes an action due to a change in state, its subsequent behavior depends on the type of action associated with the alarm.
  * For Auto Scaling policy notifications, the alarm continues to invoke the action for every period that the alarm remains in the new state.
  * For SNS notifications, no additional actions are invoked.
* An alarm has three possible states:
  * **OK**
    —The metric is within the defined threshold
  * **ALARM**
    —The metric is outside of the defined threshold
  * **INSUFFICIENT\_DATA**
    —Alarm has just started, the metric is not available, or not enough data is available for the metric to determine the alarm state
* Alarms exist only in the region in which they are created.
* Alarm actions must reside in the same region as the alarm
* Alarm history is available for the last 14 days.
* Alarm can be tested by setting it to any state using the`SetAlarmState`API \(`mon-set-alarm-state`
  command\). This temporary state change lasts only until the next alarm comparison occurs.
* Alarms can be disabled and enabled using the`DisableAlarmActions`and`EnableAlarmActions`
  APIs \(`mon-disable-alarm-actions`and`mon-enable-alarm-actions`commands\).

### Regions

* CloudWatch does not aggregate data across regions. Therefore, metrics are completely separate between regions.

## Custom Metrics

* CloudWatch allows publishing custom metrics with`put-metric-data`CLI command \(or its Query API equivalent`PutMetricData`\)
* CloudWatch creates a new metric if`put-metric-data`is called with a new metric name,  else it associates the data with the specified existing metric
* `put-metric-data`command can only publish one data point per call
* CloudWatch stores data about a metric as a series of data points and each data point has an associated time stamp
* Creating a new metric using the put-metric-data command, can take up to two minutes before statistics can be retrieved on the new metric using the get-metric-statistics command and can take up to fifteen minutes before the new metric appears in the list of metrics retrieved using the list-metrics command.
* CloudWatch allows publishing
  * Single data point
    * Data points can be published with time stamps as granular as one-thousandth of a second, CloudWatch aggregates the data to a minimum granularity of one minute
    * CloudWatch records the average \(sum of all items divided by number of items\) of the values received for every 1-minute period, as well as number of samples, maximum value, and minimum value for the same time period
    * CloudWatch uses one-minute boundaries when aggregating data points
  * Aggregated set of data points called a
    _statistics set_
    * Data can also be aggregated before being published to CloudWatch
    * Aggregating data minimizes the number of calls reducing it to a single call per minute with the statistic set of data
    * Statistics include Sum, Average, Minimum, Maximum, Data Sample
* If the application produces data that is more sporadic and have periods that have no associated data, either a the value zero \(`0`\) or no value at all can be published
* However, it can be helpful to publish zero instead of no value
  * to monitor the health of your application
    _for e.g. alarm can be configured to notify if no metrics published every 5 minutes_
  * to track the total number of data points
  * to have statistics such as minimum and average to include data points with the value 0.

## Supported Services

For Supported Services refer @[CloudWatch Supported Services](http://jayendrapatil.com/cloudwatch-monitoring-supported-aws-services/)

## Accessing CloudWatch

* CloudWatch can be accessed using
  * AWS CloudWatch console
  * CloudWatch CLI
  * AWS CLI
  * CloudWatch API
  * AWS SDKs

## CloudWatch Logs

Refer to blog post[CloudWatch Logs](http://jayendrapatil.com/aws-cloudwatch-logs/)

