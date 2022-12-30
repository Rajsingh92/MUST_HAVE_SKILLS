SCENARIO:
Suppose there is a table which contains a column NetBalance which has both negative and positive values. Now you have to write a query to dispaly sum of all positive Balances and sum of all negative Balances.



SOLUTION 1: Using   CASE statement

SELECT SUM(CASE WHEN NetBalance < 0 THEN NetBalance
           ELSE 0 END )As Negative,
       SUM(CASE WHEN NetBalance > 0 THEN NetBalance
           ELSE 0 END )As Positive
FROM dbo.BalanceInfo




SOLUTION 2: Using  SIGN and CASE statement . We know that SIGN operator returns -1 for negative values and 1 for positive values.

SELECT SUM(CASE WHEN SIGN(NetBalance)= -1 THEN NetBalance
           ELSE 0 END )As Negative,
       SUM(CASE WHEN SIGN(NetBalance)= 1 THEN NetBalance
           ELSE 0 END )As Positive
FROM dbo.BalanceInfo
