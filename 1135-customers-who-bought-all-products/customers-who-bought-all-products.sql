# Write your MySQL query statement below
SELECT DISTINCT c.customer_id
FROM Customer c
JOIN Product p ON c.product_key=p.product_key
GROUP BY c.customer_id
HAVING COUNT(DISTINCT p.product_key)=(SELECT COUNT(product_key) FROM Product);