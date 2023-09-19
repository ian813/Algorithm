# CASE WHEN THEN 사용
SELECT B.BOARD_ID, B.WRITER_ID, B.TITLE, B.PRICE, 
    CASE B.STATUS
        WHEN 'SALE' THEN '판매중'
        WHEN 'RESERVED' THEN '예약중'
        WHEN 'DONE' THEN '거래완료'
    END AS STATUS
FROM USED_GOODS_BOARD AS B
WHERE DATE_FORMAT(B.CREATED_DATE, "%Y-%m-%d") = "2022-10-05" 
ORDER BY B.BOARD_ID DESC;