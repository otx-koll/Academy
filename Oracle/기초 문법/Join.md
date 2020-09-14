## 조인
1. 일반적인 조인
```sql
SELECT <속성들>
FROM 테이블1, 테이블2
WHERE <조인조건> AND <검색조건>
```
또는
```sql
SELECT <속성들>
FROM 테이블1 INNER JOIN 테이블2 ON <조인조건>
WHERE <검색조건>
```
2. 외부조인
```sql
SELECT <속성들>
FROM 테이블1 {LEFT | RIGHT | FULL [OUTER]} JOIN
테이블2 ON <조인조건>
WHERE <검색조건>
```

3. Self Join
- 동일 테이블 사이의 조인
```sql
SELECT E1.EMPNO "ENO"
     , E1.ENAME "ENAME"
     , E2.EMPNO "MGRNO"
     , E2.ENAME "MGR_NAME"
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;
```
#### 예제

1. 고객별로 주문한 모든 도서의 총 판매액을 구하시오
```sql
SELECT name, SUM(saleprice)
FROM Customer, Orders
WHERE Customer.custid = ordrs.custid
GROUP BY Customer.name
```
2. 가격이 20,000원인 도서를 주문한 고객의 이름과 도서의 이름을 구하시오
```sql
SELECT Customer.name, book.bookname
FROM Customer, Orders, Book
WHERE Customer.custid = Orders.custid AND Orders.bookid = Book.bookid AND Book.price = 20000
```
3. 도서를 구매하지 않은 고객을 포함하여 고객의 이름과 고객이 주문한 도서의 판매가격
```sql
SELECT Customer.name, saleprice
FROM Customer LEFT OUTER JOIN
```
4. 학생 테이블(STUDENT)과 학과 테이블(DEPARTMENT), 교수테이블(PROFESSOR)을 JOIN하여 학생의 이름과 학과이름, 학생의 지도교수 이름을 출력
```sql
SELECT S.NAME STU_NAME
     , D.DNAME DEPT_NAME
     , P.NAME PROF_NAME
FROM STUDENT S, PROFESSOR P, DEPARTMENT D
WHERE S.PROFNO = P.PROFNO
  AND P.DEPTNO = D.DEPTNO;
```
5. STUDENT 테이블을 조회하여 1전공(DEPTNO1)이 101번인 학생들의 이름과 지도교수 이름을 출력하라
```sql
SELECT S.NAME
     , P.NAME
FROM STUDENT S, PROFESSOR P
WHERE S.PROFNO = P.PROFNO AND S.DEPTNO1 = 101;
```
STU_NAME | PROF_NAME
--|--
James Seo	|Audie Murphy
Richard Dreyfus	|Angela Bassett
Billy Crystal	|Angela Bassett

6. CUSTOMER 테이블과 GIFT테이블을 JOIN하여 고객별로 마일리지 포인트를 조회한 후 해당 마일리리 점수로 받을 수 있는 상품을 조회하여 고객의 이름과 받을 수 있는 상품 명을 출력하시오
```sql
SELECT C.GNAME CUST_NAME
     , TO_CHAR(C.POINT,'999,999') "POINT"
     , G.GNAME GIFT_NAME
FROM CUSTOMER C, GIFT G
WHERE C.POINT BETWEEN G.G_START AND G.G_END;
```
비등가조인

7. student테이블과 score테이블, hakjum 테이블을 조회하여 학생들의 이름과 점수와 학점을 출력하세요
```sql
SELECT S.NAME "STU_NAME"
     , O.TOTAL "SCORE"
     , H.GRADE "CREDIT"
FROM STUDENT S, SCORE O, HAKJUM H
WHERE S.STUDNO = O.STUDNO
AND O.TOTAL BETWEEN H.MIN_POINT AND H.MAX_POINT
ORDER BY O.TOTAL DESC;
```
### Outer Join
```sql
SELECT A.NAME STU_NAME
     , B.NAME PROF_NAME
FROM STUDENT A LEFT JOIN PROFESSOR B
    ON A.PROFNO = B.PROFNO;
```
=
```sql
FROM STUDENT A LEFT OUTER JOIN PROFESSOR B
    ON A.PROFNO = B.PROFNO;
```
=
```sql
FROM STUDENT A, PROFESSOR B
WHERE A.PROFNO = B.PROFNO(+);
```
- B.PROFNO의 NULL값도 나온다
- +가 A.PROFNO에 있으면 A.PROFNO를 기준으로 출력

### FULL OUTER JOIN
```sql
SELECT S.NAME STU_NAME
     , P.NAME PROF_NAME
FROM STUDENT S FULL OUTER JOIN PROFESSOR P
ON S.PROFNO = P.PROFNO
ORDER BY S.NAME;
```
