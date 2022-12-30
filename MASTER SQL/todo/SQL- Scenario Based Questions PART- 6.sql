SCENARIO:  We have table COUNTRY_INFO which contains country names. Country_name field has some junk characters. Those junk characters are listed in Value_1 column. Those junk characters in Country_name  need to be replaced with value_2 values for all occurrences while displaying. Please see below the scenario in details.



SOLUTION:

We can get this done by using the  Oracle string functions TRANSLATE as below .

SELECT COUNTRY_NAME, VALUE_1,VALUE_2,
TRANSLATE(COUNTRY_NAME,VALUE_1,VALUE_2) UPDATED_COUNTRY_NAME
FROM COUNTRY_INFO;

