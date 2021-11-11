/*
The students table stores all student information, including student id and student name
The companies table stores all company information, including company id and company name
The recording table stores all resume delivery data, including student id (student_id) and company id (company_id)
Please write SQL statements to query the names of all students who have not submitted their resumes to Alibaba.

1: students
columns_name	type	explaination
id	int unsigned	primary key
name	varchar	student name

2: companies
columns_name	type	explaination
id	int unsigned	primary key
name	varchar	company name
address	varchar	company address

3: recording
columns_name	type	explaination
id	int unsigned	primary key
delivery_date	date	delivery date
company_id	int	company id
student_id	int	student id

*/

SELECT name
FROM students
WHERE name NOT IN (
    SELECT  s.name
    FROM recording r
    INNER JOIN companies c ON r.company_id = c.id
    INNER JOIN students s ON r.student_id = s.id
    WHERE c.name =  "Alibaba"
)




