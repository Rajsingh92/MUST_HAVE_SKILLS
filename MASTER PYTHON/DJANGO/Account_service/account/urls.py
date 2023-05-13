from django.urls import path,include
from .views import AccountViewSet,AddMoneyView,WithdrawMoneyView

urlpatterns = [
    path('accounts/', AccountViewSet.as_view({
        'get': 'list',
        'post': 'create'
    })),
    path('accounts/<str:account_no>', AccountViewSet.as_view({
        'get': 'retrieve',
        'delete': 'destroy'
    })),
    path('accounts/add_money/<str:account_no>', AddMoneyView.as_view()),
    path('accounts/withdraw_money/<str:account_no>', WithdrawMoneyView.as_view()),
]





    # path('accounts/<int:account_id>/delete/', DeleteAccountView.as_view()),
