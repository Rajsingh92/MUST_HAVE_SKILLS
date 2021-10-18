'''
This script will create a DynamoDB table 
with ON-DEMAND capacity within your AWS 
account. 

REQUIREMENTS
---
This script assumes you have AWS CLI installed
and configured using static credentials
within your ~/.aws/credentials file

You also need to install the following:
    boto3

'''

# IMPORTING LIBRARIES
import boto3

# SETTING BOTO CLIENTS FOR USE
dynamodbClient = boto3.client('dynamodb')

# MAIN FUNCTION THAT WILL CREATE OUR TABLE FOR US.
def main():
    dynamodbClient.create_table(
        TableName = 'emrDemo',
        BillingMode = 'PAY_PER_REQUEST',
        AttributeDefinitions = [
            # TODO ADD
            {
                'AttributeName': 'id',
                'AttributeType': 'N'
            }
        ],
        KeySchema = [
            {
                'AttributeName': 'id',
                'KeyType': 'HASH'
            }
        ]
    )

print('Creating table now...')
main()
print('Check progress in AWS and then run "put_item" script...')