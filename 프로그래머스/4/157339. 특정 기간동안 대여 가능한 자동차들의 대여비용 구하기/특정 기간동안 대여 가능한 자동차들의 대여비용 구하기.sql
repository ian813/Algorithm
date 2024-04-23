SELECT A.CAR_ID
     , A.CAR_TYPE
     , (1 - B.DISCOUNT_RATE / 100) * 30 * A.DAILY_FEE FEE
  FROM CAR_RENTAL_COMPANY_CAR A
     , CAR_RENTAL_COMPANY_DISCOUNT_PLAN B
 WHERE A.CAR_TYPE = B.CAR_TYPE
   AND A.CAR_ID NOT IN (
                        SELECT CAR_ID
                          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                         WHERE (CAR_ID, END_DATE) IN (SELECT CAR_ID, MAX(END_DATE)
                                                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                                     GROUP BY CAR_ID)
                           AND TO_CHAR(START_DATE, 'YYYY-MM-DD') <= '2022-11-30'
                           AND TO_CHAR(END_DATE, 'YYYY-MM-DD') >= '2022-11-01'
                       )
   AND A.CAR_TYPE IN ('세단', 'SUV')
   AND B.DURATION_TYPE = '30일 이상'
   AND (1 - B.DISCOUNT_RATE / 100) * 30 * A.DAILY_FEE >= 500000
   AND (1 - B.DISCOUNT_RATE / 100) * 30 * A.DAILY_FEE < 2000000
ORDER BY FEE DESC
       , A.CAR_TYPE ASC
       , A.CAR_ID DESC;