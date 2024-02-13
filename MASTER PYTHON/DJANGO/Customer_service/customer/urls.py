from django.urls import path,include
from .views import CustomerViewSet

urlpatterns = [
    path('customers/', CustomerViewSet.as_view({
        'get': 'list',
        'post': 'create'
    })),
    path('customers/<str:account_no>', CustomerViewSet.as_view({
        'get': 'retrieve',
        'put': 'update',
        'delete': 'destroy'
    })),
]


