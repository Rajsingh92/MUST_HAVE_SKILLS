SELECT
    (CASE
        WHEN Occupation = 'Doctor' THEN CONCAT(Name, '(D)')
        WHEN Occupation = 'Actor' THEN CONCAT(Name, '(A)')
        WHEN Occupation = 'Singer' THEN CONCAT(Name, '(S)')
        WHEN Occupation = 'Professor' THEN CONCAT(Name, '(P)')
    END)  as N
FROM OCCUPATIONS
ORDER BY N;


SELECT CONCAT('There are a total of ', COUNT(OCCUPATION), ' ', LOWER(Occupation), 's.')
FROM OCCUPATIONS
GROUP BY Occupation
ORDER BY COUNT(OCCUPATION), OCCUPATION





