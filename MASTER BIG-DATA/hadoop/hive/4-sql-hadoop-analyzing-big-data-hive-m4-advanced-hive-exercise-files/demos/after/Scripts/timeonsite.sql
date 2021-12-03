FROM (
FROM (
SELECT
  userid
  ,unix_timestamp(logtime, 'MM/dd/yyyy HH:mm:ss') uxt 
FROM
   pluralsight.page_views
) src
SELECT
 src.userid
 ,src.uxt - LAG(src.uxt, 1, src.uxt) OVER (PARTITION BY src.userid ORDER BY src.uxt) diff
) diffs
SELECT
  userid
 ,SUM(diff)
GROUP BY
  userid