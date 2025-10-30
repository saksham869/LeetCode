-- Problem #1164
-- Table: Products(product_id INT, new_price INT, change_date DATE)

SELECT
  p.product_id,
  COALESCE(l.new_price, 10) AS price
FROM (
  SELECT DISTINCT product_id
  FROM Products
) AS p
LEFT JOIN (
  SELECT
    product_id,
    new_price
  FROM Products AS t
  WHERE t.change_date = (
    SELECT MAX(change_date)
    FROM Products
    WHERE product_id = t.product_id
      AND change_date <= '2019-08-16'
  )
) AS l
  ON p.product_id = l.product_id;
