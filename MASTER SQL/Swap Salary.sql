

update Salary
set sex = CASE
    when sex = "m" then "f"
    else 'm'
END

