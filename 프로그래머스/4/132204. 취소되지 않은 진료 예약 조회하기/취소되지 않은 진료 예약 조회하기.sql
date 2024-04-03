-- 코드를 입력하세요
SELECT
    AP.APNT_NO,
    AP.PT_NAME,
    AP.PT_NO,
    AP.MCDP_CD,
    D.DR_NAME,
    AP.APNT_YMD
FROM
    (SELECT
        A.MDDR_ID,
        A.APNT_NO,
        P.PT_NAME,
        P.PT_NO,
        A.MCDP_CD,
        A.APNT_YMD
    FROM APPOINTMENT A
        LEFT OUTER JOIN
        PATIENT P
        ON A.PT_NO = P.PT_NO
    WHERE TO_CHAR(A.APNT_YMD, 'YYYY-MM-DD') = '2022-04-13'
        AND A.APNT_CNCL_YN = 'N'
        AND A.MCDP_CD = 'CS') AP
LEFT OUTER JOIN
DOCTOR D
ON AP.MDDR_ID = D.DR_ID
ORDER BY AP.APNT_YMD;


