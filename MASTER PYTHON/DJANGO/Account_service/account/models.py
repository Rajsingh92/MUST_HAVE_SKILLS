from django.db import models

# Create your models here.
class Account(models.Model):
    account_no = models.CharField(unique=True,max_length=10)
    balance = models.DecimalField(max_digits=20, decimal_places=4, default=0.0)

    def __str__(self):
        return self.name
    

class Transaction(models.Model):
    account_no = models.ForeignKey(Account, on_delete=models.CASCADE)
    amount = models.DecimalField(max_digits=10, decimal_places=2)
    transaction_type = models.CharField(max_length=10, choices=[('debit', 'Debit'), ('credit', 'Credit')])
    transaction_time = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return "{} transaction of ${} on {}".format(self.transaction_type, self.amount, self.transaction_time)

