
SQL- Scenario based questions Part 1.
                                   Now the recruiters are setting a new trend by asking a scenario based questions in an interview.  Keeping in this mind, we have come up with many standard scenario based questions.

Scenario: You have been given the following Table "Annualhike". This table contains the name of employee, salary, designation, CRR and the increment. You have to test the increment column of the table based on the below logic:

Employee gets an increment of 15% of Salary if he/she gets CRR 1+.
Employee gets an increment of 10% of Salary if he/she gets CRR 1.
Employee gets an increment of 5% of Salary if he/she gets CRR 2.

You have to find out the records if there are any incorrect population in Increment field.



Method1
SELECT * FROM Annualhike A
WHERE Increment <> (SELECT CASE WHEN A.CRR='2'
                      THEN .05* SalaryPackage
      WHEN A.CRR='1'  THEN .1* SalaryPackage
      WHEN A.CRR='1+' THEN .15* SalaryPackage
      END AS Increment)


Method 2
SELECT * FROM Annualhike
EXCEPT
SELECT Employee,SalaryPackage,Designation,CRR ,
              CASE WHEN CRR='2' THEN .05* SalaryPackage
                         WHEN CRR='1' THEN .1* SalaryPackage
                         WHEN CRR='1+' THEN .15* SalaryPackage
              END AS Increment
 FROM Annualhike

