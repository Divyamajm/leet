# Write your MySQL query statement below
SELECT DISTINCT author_id As id
FROM Views
WHERE author_id=viewer_id
ORDER BY author_id ASC;