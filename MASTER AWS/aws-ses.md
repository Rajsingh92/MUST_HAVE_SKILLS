# AWS Simple Email Service – SES

* SES is a managed service and ideal for sending bulk emails at scale
* SES acts as an outbound email server and eliminates the need to support own software or applications to do the heavy lifting of email transport
* Existing email server can also be configure to send outgoing emails through SES with no change in any settings in the email clients
* Maximum message size including attachments is 10 MB per message \(after base64 encoding\).

## SES Characteristics

* Compatible with SMTP
* Applications can send email using a single API call in many supported languages Java, .Net, PHP, Perl, Ruby, HTTPs etc
* Optimized for highest levels of uptime, availability and scales as per the demand
* Provides sandbox environment for testing

## Sending Limits

* Production SES has a set of sending limits which include
  * Sending Quota – max number of emails in 24-hour period
  * Maximum Send Rate – max number of emails per second
* SES automatically adjusts the limits upward as long as emails are of high quality and they are sent in a controlled manner, as any spike in the email sent might be considered to be spams.
* Limits can also be raised by submitting a Quota increase request

## SES Best Practices

* Send high-quality and real production content that your recipients want
* Only send to those who have signed up for the mail
* Unsubscribe recipients who have not interacted with the business recently
* Have low bounce and compliant rates and remove bounced or complained addresses, using SNS to monitor bounces and complaints, treating them as opt-out
* Monitor the sending activity



