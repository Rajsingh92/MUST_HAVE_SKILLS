from factories.investor import Investor
from factories.saver import Saver


for factory in Investor, Saver:
    cust = factory.create_commercial()
    cust = cust('Acme Corp')
    cust.report_type()
    cust = factory.create_government()
    cust = cust('Prussia')
    cust.report_type()
    cust = factory.create_retail()
    cust = cust('Douglas Adams')
    cust.report_type()
