

Problem Statement:-

Transatcion_tbl Table has four columns CustID, TranID, TranAmt, and  TranDate. User has to display all these fields along with maximum TranAmt for each CustID and ratio of TranAmt and maximum TranAmt for each transaction.



Solution 1: By using Subquery


SELECT A.CustID,TranID,A.TranAmt,MaxTranAmt,(TranAmt/MaxTranAmt) AS Ratio,TranDate
FROM Transaction_Tbl A
INNER JOIN(SELECT CustID, Max(TranAmt) As MaxTranAmt FROM Transaction_Tbl
GROUP BY CustID) B
ON A.CustID=B.CustID

Solution 2: By using CTE (Common Table Expression )

WITH CTE (CustID, TranID, TranAmt) AS(SELECT CustID, TranID, TranAmt FROM Transaction_Tbl
),CTE_MaxTran(CustID, MaxTranAmt) AS(SELECT CustID, Max(TranAmt) As MaxTranAmt FROM Transaction_Tbl
GROUP BY CustID
)SELECT A.TranID,A.TranAmt,MaxTranAmt,(TranAmt/MaxTranAmt) AS Ratio
FROM CTE A
INNER JOIN CTE_MaxTran B
ON A.CustID=B.CustID


