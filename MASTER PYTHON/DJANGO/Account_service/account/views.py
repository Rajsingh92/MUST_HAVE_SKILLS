from django.shortcuts import render
from .serializers import AccountSerializer,TransactionSerializer
from rest_framework import viewsets,status
from rest_framework.response import Response
from .models import Account
from rest_framework.views import APIView
from rest_framework.exceptions import NotFound, ValidationError
from decimal import Decimal

# Create your views here.
class AccountViewSet(viewsets.ViewSet):
    """
    A simple ViewSet for managing customers.
    """
    def list(self, request):
        customers = Account.objects.all()
        serializer = AccountSerializer(customers, many=True)
        return Response(serializer.data)
    
    def create(self, request):
        serializer = AccountSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
    
    def retrieve(self, request, account_no=None):
        customer = Account.objects.get(account_no=account_no)
        serializer = AccountSerializer(customer)
        return Response(serializer.data)
    
    def destroy(self, request, account_no=None):
        customer = Account.objects.get(account_no=account_no)
        customer.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)




class AddMoneyView(APIView):
    def post(self, request, account_no):
        try:
            account = Account.objects.get(account_no=account_no)
        except Account.DoesNotExist:
            raise NotFound('Account not found')

        amount = request.data.get('amount')
        if not amount:
            raise ValidationError('Amount is required')

        print(amount)
        try:
            # amount = float(amount)
            amount = Decimal(amount)
        except ValueError:
            raise ValidationError('Invalid amount')

        account.balance += amount
        account.save()

        request.data['account_no'] = account_no
        request.data['transaction_type'] = "credit"

        serializer = TransactionSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        
        serializer = AccountSerializer(account)
        return Response(serializer.data, status=status.HTTP_200_OK)




class WithdrawMoneyView(APIView):
    def post(self, request, account_no):
        try:
            account = Account.objects.get(account_no=account_no)
        except Account.DoesNotExist:
            raise NotFound('Account not found')

        amount = request.data.get('amount')
        if not amount:
            raise ValidationError('Amount is required')

        try:
            amount = Decimal(amount)
        except ValueError:
            raise ValidationError('Invalid amount')

        if account.balance < amount:
            raise ValidationError('Insufficient balance')

        account.balance -= amount
        account.save()

        request.data['account_no'] = account_no
        request.data['transaction_type'] = "debit"

        serializer = TransactionSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()

        serializer = AccountSerializer(account)
        return Response(serializer.data, status=status.HTTP_200_OK)



