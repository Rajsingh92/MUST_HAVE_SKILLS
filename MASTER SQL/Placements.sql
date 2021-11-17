
SELECT s.Name FROM Students AS s 
JOIN Packages AS sp ON s.ID = sp.ID 
JOIN Friends AS f ON s.ID = f.ID
JOIN Packages AS fp ON f.Friend_ID = fp.ID
WHERE sp.Salary < fp.Salary
ORDER BY fp.Salary;



