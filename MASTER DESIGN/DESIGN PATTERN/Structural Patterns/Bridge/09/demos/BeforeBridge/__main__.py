from annual import Annual
from monthly import Monthly
from datetime import datetime

def main():
    sub1 = Monthly('Bob', datetime.today())
    sub2 = Annual('Carol', datetime.today())

    print(f'Subscriber: {sub1.subscriber}, Cost: {sub1.price}, Expiration: {sub1.expiration}')
    print(f'Subscriber: {sub2.subscriber}, Cost: {sub2.price}, Expiration: {sub2.expiration}')

if __name__ == "__main__":
    main()
