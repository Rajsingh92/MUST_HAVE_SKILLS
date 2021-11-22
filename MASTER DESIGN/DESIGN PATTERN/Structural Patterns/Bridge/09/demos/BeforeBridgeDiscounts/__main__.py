from monthly import Monthly
from monthly_corporate import MonthlyCorporate
from monthly_student import MonthlyStudent
from annual import Annual
from annual_corporate import AnnualCorporate
from annual_student import AnnualStudent
from datetime import datetime

def main():
    sub1 = MonthlyCorporate('Bob', datetime.today())
    sub2 = AnnualStudent('Carol', datetime.today())
    sub3 = MonthlyCorporate('Ted', datetime.today())
    sub4 = AnnualStudent('Alice', datetime.today())

    print('\nDiscounted subscriptions:\n')
    print(f'Subscription: {sub1.subscriber}, Cost: {sub1.price}, Expiration: {sub1.expiration}')
    print(f'Subscription: {sub2.subscriber}, Cost: {sub2.price}, Expiration: {sub2.expiration}')
    print(f'Subscription: {sub3.subscriber}, Cost: {sub3.price}, Expiration: {sub3.expiration}')
    print(f'Subscription: {sub4.subscriber}, Cost: {sub4.price}, Expiration: {sub4.expiration}')

    print('\nNormal subscriptions:\n')
    sub5 = Monthly('Fred', datetime.today())
    sub6 = Annual('Wilma', datetime.today())

    print(f'Movie: {sub5.subscriber}, Cost: {sub5.price}, Expiration: {sub5.expiration}')
    print(f'Movie: {sub6.subscriber}, Cost: {sub6.price}, Expiration: {sub6.expiration}')

if __name__ == "__main__":
    main()
