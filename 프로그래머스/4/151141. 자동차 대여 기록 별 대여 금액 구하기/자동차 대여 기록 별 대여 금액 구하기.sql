-- 코드를 입력하세요
SELECT B.HISTORY_ID
     , (1 - (CASE WHEN (B.END_DATE - B.START_DATE + 1) >= 90
                  THEN (
                      SELECT DISCOUNT_RATE
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                       WHERE CAR_TYPE = '트럭'
                         AND DURATION_TYPE LIKE '90%'
                      )
                  WHEN (B.END_DATE - B.START_DATE + 1) >= 30
                  THEN (
                       SELECT DISCOUNT_RATE
                         FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                        WHERE CAR_TYPE = '트럭'
                          AND DURATION_TYPE LIKE '30%'
                       )
                  WHEN (B.END_DATE - B.START_DATE + 1) >= 7
                  THEN (
                       SELECT DISCOUNT_RATE
                         FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                        WHERE CAR_TYPE = '트럭'
                          AND DURATION_TYPE LIKE '7%'
                       )
                  ELSE 0
              END
        ) / 100
        )
        * (B.END_DATE - B.START_DATE + 1) * A.DAILY_FEE AS FEE
  FROM CAR_RENTAL_COMPANY_CAR A
     , CAR_RENTAL_COMPANY_RENTAL_HISTORY B 
 WHERE A.CAR_ID = B.CAR_ID
   AND A.CAR_TYPE = '트럭'
 ORDER BY FEE DESC
     , B.HISTORY_ID DESC
;