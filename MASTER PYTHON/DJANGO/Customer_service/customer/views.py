from rest_framework import viewsets,status
from rest_framework.response import Response
from .models import Customer
from .serializers import CustomerSerializer
#from .producer import publish
import requests

class CustomerViewSet(viewsets.ViewSet):
    """
    A simple ViewSet for managing customers.
    """

    def list(self, request):
        customers = Customer.objects.all()
        serializer = CustomerSerializer(customers, many=True)
        return Response(serializer.data)
    
    def create(self, request):
        serializer = CustomerSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        #publish('customer_created', serializer.data)

        print(request.data)

        url = 'http://localhost:8002/accounts/'
        data = {
            'account_no': request.data['account_no']
        }

        response = requests.post(url, json=data)

        print(response.text)


        return Response(serializer.data, status=status.HTTP_201_CREATED)
    
    def retrieve(self, request, account_no=None):
        customer = Customer.objects.get(account_no=account_no)
        serializer = CustomerSerializer(customer)
        return Response(serializer.data)

    def update(self, request, account_no=None):
        customer = Customer.objects.get(account_no=account_no)
        serializer = CustomerSerializer(instance=customer, data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        return Response(serializer.data, status=status.HTTP_202_ACCEPTED)

    def destroy(self, request, account_no=None):
        customer = Customer.objects.get(account_no=account_no)
        customer.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


