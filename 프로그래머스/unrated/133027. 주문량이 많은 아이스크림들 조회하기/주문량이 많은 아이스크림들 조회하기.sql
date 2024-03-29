-- 코드를 입력하세요
# SELECT J.FLAVOR, SUM(F.TOTAL_ORDER) FROM FIRST_HALF AS F LEFT OUTER JOIN JULY AS J
# ON F.FLAVOR = J.FLAVOR
# SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF;
# SELECT FLAVOR, TOTAL_ORDER FROM JULY;
SELECT F.FLAVOR FROM FIRST_HALF AS F LEFT OUTER JOIN
(SELECT SHIPMENT_ID, FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER FROM JULY GROUP BY FLAVOR) AS J
ON F.FLAVOR = J.FLAVOR GROUP BY F.FLAVOR ORDER BY F.TOTAL_ORDER + J.TOTAL_ORDER DESC
LIMIT 3