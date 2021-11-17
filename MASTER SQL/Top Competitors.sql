SELECT 
    h.hacker_id, 
    h.name 
FROM Submissions AS s 
JOIN Hackers AS h ON s.hacker_id = h.hacker_id
JOIN Challenges AS c ON s.challenge_id = c.challenge_id
JOIN Difficulty AS d ON c.difficulty_level = d.difficulty_level
WHERE s.score = d.score 
GROUP BY h.hacker_id, h.name 
HAVING COUNT(*)>1 
ORDER BY COUNT(*) DESC, h.hacker_id;


