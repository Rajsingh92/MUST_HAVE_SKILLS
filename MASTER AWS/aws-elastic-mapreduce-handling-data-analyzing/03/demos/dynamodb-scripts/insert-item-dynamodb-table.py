'''
This script will insert items into
the table created by the previous
script.

REQUIREMENTS
---
This script assumes you have AWS CLI installed
and configured using static credentials
within your ~/.aws/credentials file

You also need to install the following:
    boto3
    namegenerator

'''

# IMPORTING LIBRARIES
import boto3
import namegenerator
import random
import time

# SETTING BOTO CLIENTS FOR USE
dynamodbClient = boto3.client('dynamodb')

# SETTING DOB LIST
dobList = [
    '01-01-1990',
    '02-01-1991',
    '11-11-1965', 
    '02-02-1978',
    '09-09-1926',
    '01-01-1990',
    '02-01-1991', 
    '11-11-1965',
    '02-02-1978',
    '09-09-1926'
    ]

# MAIN FUNCTION THAT PUT OUR ITEMS.
def main(iterator, name, date):
    dynamodbClient.put_item(
        TableName = 'emrDemo',
        Item = {
            'id': {
                'N': str(iterator)
            },
            'dob': {
                'S': date
            },
            'name': {
                'S': name
            }
        }
    )

for i in range (1,11):
    print('Adding item number {} of 10...'.format(i))
    tmpName = namegenerator.gen()
    tmpYear = dobList[i - 1]
    main(i, tmpName, tmpYear)


print('Should be all done...')
