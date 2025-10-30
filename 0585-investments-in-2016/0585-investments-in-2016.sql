WITH SameTIV2015 AS (
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
),
UniqueCity AS (
    SELECT lat, lon
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
)
SELECT
    ROUND(SUM(i.tiv_2016), 2) AS TIV_2016
FROM Insurance AS i
WHERE i.tiv_2015 IN (SELECT tiv_2015 FROM SameTIV2015)
  AND (i.lat, i.lon) IN (SELECT lat, lon FROM UniqueCity);
