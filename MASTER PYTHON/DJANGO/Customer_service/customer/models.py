from django.db import models


# Create your models here.
class Customer(models.Model):
    app_label = 'customers'
    
    account_no = models.PositiveIntegerField(unique=True)
    name = models.CharField(max_length=100)
    email = models.EmailField()
    phone = models.CharField(max_length=12)
    city = models.CharField(max_length=15)
    postal_code = models.CharField(max_length=15)
    state = models.CharField(max_length=15)
    country = models.CharField(max_length=20)
    address = models.TextField()

    def __str__(self):
        return self.name


# {
#     "account_no" : "12345",
#     "name": "raj",
#     "email": "abc@abc.com",
#     "phone": "123456789",
#     "city": "city",
#     "postal_code": "0761",
#     "state": "state",
#     "country": "country",
#     "address": "address"
# }

