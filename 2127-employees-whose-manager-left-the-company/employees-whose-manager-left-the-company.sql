# Write your MySQL query statement below
SELECT employee_id
FROM Employees
-- JOIN Employees e2 ON e1.employee_id=e2.manager_id
WHERE manager_id NOT IN (SELECT employee_id FROM Employees) AND salary<30000
ORDER BY employee_id;