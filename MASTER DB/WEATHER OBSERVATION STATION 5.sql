/*
Query the two cities in STATION with the shortest and longest CITY names, as well as their 
respective lengths (i.e.: number of characters in the name). If there is more than one smallest 
or largest city, choose the one that comes first when ordered alphabetically.



STATION 

ID
CITY
STATE
LAT_N
LONG_W

*/

SELECT TOP 1 CITY ,LEN(CITY) l
FROM STATION
ORDER BY l ASC, CITY ASC;

SELECT TOP 1 CITY ,LEN(CITY) l
FROM STATION
ORDER BY l DESC, CITY ASC;
