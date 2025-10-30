WITH Daily AS (
    SELECT
        visited_on,
        SUM(amount) AS total_amount
    FROM Customer
    GROUP BY visited_on
),
Windowed AS (
    SELECT
        d.visited_on,
        SUM(d2.total_amount) AS amount,
        ROUND(SUM(d2.total_amount) / 7, 2) AS average_amount
    FROM Daily d
    JOIN Daily d2
      ON d2.visited_on BETWEEN DATE_SUB(d.visited_on, INTERVAL 6 DAY) AND d.visited_on
    GROUP BY d.visited_on
    HAVING COUNT(d2.visited_on) = 7
)
SELECT visited_on, amount, average_amount
FROM Windowed
ORDER BY visited_on;
