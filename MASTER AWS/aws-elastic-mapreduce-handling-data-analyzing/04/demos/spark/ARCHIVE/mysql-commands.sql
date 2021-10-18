
CREATE TABLE test (
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL
);


INSERT INTO test (name, age)
    VALUES
        ("andru", 28);
INSERT INTO test (name, age)
    VALUES
        ("john", 10);
INSERT INTO test (name, age)
    VALUES
        ("jess", 11);
INSERT INTO test (name, age)
    VALUES
        ("camille", 55);

INSERT INTO test (name, age)
    VALUES
        ("diego", 33);

INSERT INTO test (name, age)
    VALUES
        ("emmanuel", 44);

INSERT INTO test (name, age)
    VALUES
        ("frank", 55);

INSERT INTO test (name, age)
    VALUES
        ("george", 66);

INSERT INTO test (name, age)
    VALUES
        ("zebra", 77);


SELECT name, age
FROM test
WHERE name = "andru";