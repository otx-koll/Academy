## SELECT 기본 문법
```
SLECT[ALL | DISTINCT]속성이름
FROM 테이블이름
[WHERE 검색조건]
[GROUP BY 속성이름]
[HAVING 검색조건]
[ORDER BY 속성이름 [ASC | DESC]]
```
### WHERE 절에 조건으로 사용할 수 있는 술어
- 비교 : =, <>, <, <=, >, >=
- 범위 : BETWEEN
- 집합 : IN, NOT IN
	- price IN(1000,2000,3000)
- 패턴 : LIKE
	- bookname LIKE '축구의 역사'
	- bookname LIKE '%축구%'
- NULL : IS NULL, IS NOT NULL
- 복합조건 : AND, OR, NOT

### 와일드 문자
- \+ : 문자열 연결
- % : 0개 이상의 문자열과 일치 ex) '%축구%' : 축구를 포함하는 문자열
- [] : 1개의 문자와 일치 ex) '[0-5]%' : 0-5사이 숫자로 시작하는 문자열
- [^] : 1개의 문자와 불일치 ex) '[^0-5]%' : 0-5사이 숫자로 시작하지 않는 문자열
- _ : 특정 위치의 1개의 문자와 일치 ex) '_구%' : 두번째 위치에 '구'가 들어가는 문자열

### ORDER BY
- 오름차순 : ASC(기본값)
- 내림차순 : DESC

### 집계 함수
- SUM([ALL | DISTINCT] 속성이름)
- AVG([ALL | DISTINCT] 속성이름)
- COUNT({[ALL | DISTINCT] 속성이름 | *})
- MAX([ALL | DISTINCT] 속성이름)
- MIN([ALL | DISTINCT] 속성이름)
- STDDEV : 표준편차
- VARIANCE : 분산

### 예제
예1) emp테이블의 deptno와 sal을 출력하는데 sal은 null값인 행도 합하여 평균을 구하라
```
SELECT DEPTNO
     , JOB
     , AVG(NVL(SAL,0)) "A"
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;
```
DEPTNO | JOB | A
--|--|--
10	|PRESIDENT	|5000
20	|CLERK	|800
30	|CLERK	|950

예2) EMP테이블에서 평균 급여가 2000이상인 SAL과 DEPTNO를 구하시오
```
SELECT DEPTNO
     , ROUND(AVG(NVL(SAL,0)),2) "A"
FROM EMP
GROUP BY DEPTNO
HAVING AVG(NVL(SAL, 0)) > 2000;
```
DEPTNO | A
--|--
20	|2258.33
10	|2916.67

### GROUP BY 
- GROUP BY <속성>
- 어느 고객이 얼마나 주문했는지 알고 싶다

### HAVING
- HAVING <검색조건>


### 예제
1. 모든 도서의 이름과 가격을 검색하시오
```
SELECT bookename, price FROM book;
```

2. 도서 테이블에 있는 모든 출판사를 검색하시오(중복은 제거한다)
```
SELECT DISTINCT publisher FROM book;
```

3. 가격이 1000이상, 2000 이하인 도서를 검색하시오
```
SELECT * FROM Book WHERE price BETWEEN 1000 AND 2000;
```

4. 도서 이름의 왼쪽 두 번째 위치에 '구'라는 문자열을 갖는 도서 검색
```
SELECT * FROM Book WHERE bookname LIKE '_구%'
```

5. 도서를 가격의 내림차순으로 검색하시오. 가격이 같을시 출판사의 오름차순으로 검색
```
SELECT * FROM Book ORDER BY price DESC, publisher ASC;
```

6. 마당서점의 도서 판매 건수
```
SELECT COUNT(*) FROM Orders;
```

7. 가격이 8,000원 이상인 도서를 구매한 고객에 대하여 고객별 주문 도서의 총 수량을 구하시오. 단, 두 권 이상 구매한 고객만 구한다.
```
SELECT custid, COUNT(*) AS 도서수량
FROM Orders
WHERE saleprice >= 8000
GROUP BY custid
HAVING count(*) >= 2
```
---
### 조인
1. 일반적인 조인
```
SELECT <속성들>
FROM 테이블1, 테이블2
WHERE <조인조건> AND <검색조건>
```
또는
```
SELECT <속성들>
FROM 테이블1 INNER JOIN 테이블2 ON <조인조건>
WHERE <검색조건>
```
2. 외부조인
```
SELECT <속성들>
FROM 테이블1 {LEFT | RIGHT | FULL [OUTER]} JOIN
테이블2 ON <조인조건>
WHERE <검색조건>
```
#### 예제

1. 고객별로 주문한 모든 도서의 총 판매액을 구하시오
```
SELECT name, SUM(saleprice)
FROM Customer, Orders
WHERE Customer.custid = ordrs.custid
GROUP BY Customer.name
```
2. 가격이 20,000원인 도서를 주문한 고객의 이름과 도서의 이름을 구하시오
```
SELECT Customer.name, book.bookname
FROM Customer, Orders, Book
WHERE Customer.custid = Orders.custid AND Orders.bookid = Book.bookid AND Book.price = 20000
```
3. 도서를 구매하지 않은 고객을 포함하여 고객의 이름과 고객이 주문한 도서의 판매가격
```
SELECT Customer.name, saleprice
FROM Customer LEFT OUTER JOIN
```
---
### 부속질의
- SQL문 내에 또 다른 SQL문을 작성

#### 예제
도서를 구매한 적 있는 고객의 이름을 검색하시오
```
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN
(SELECT CUSTID
FROM ORDERS)
```
출판사별로 출판사의 평균 도서 가격보다 비싼 도서를 구하시오
```
SELECT B1.BOOKNAME
FROM BOOK B1
WHERE B1.PRICE >
(SELECT AVG(B2.PRICE)
FROM BOOK B2
WHERE B2.PUBLISHER = B1.PUBLISHER)
```
---
### 집합연산
- 합집합 : UNION
- 차집합 : EXCEPT
- 교집합 : INTERSECT

EX) 도서를 주문하지 않는 고객의 이름을 보이시오
```
SELECT NAME
FROM CUSTOMER
EXCEPT
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN
(SELECT CUSTID
FROM ORDERS)
```
### EXISTS
- 원래 단어에서 의미하는 것과 같이 조건에 맞는 튜플이 존재하면 결과에 포함시킴
- 부속질의문의 어떤 행이 조건에 만족하면 참인 반면 NOT EXISTS는 부속질의문의 모든 행이 조건에 만족하지 않을 때만 참임

EX) 주문이 있는 고객의 이름과 주소를 보이시오
```
SELECT NAME, ADDRESS
FROM CUSTOMER CS
WHERE EXISTS
(SELECT *
FROM ORDERS OD
WHERE CS.CUSTID=OD.CUSTID)
```
