# Write your MySQL query statement below
SELECT  p.name
FROM Customer p
where p.referee_id!=2 or p.referee_id IS NULL;
