#### 2. 마당서점의 운영자가 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오

(1) 마당서점 도서의 총 개수
```sql
SELECT COUNT(*)
FROM BOOK
```
COUNT(*)
--|
10
    
(2) 마당서점에 도서를 출고하는 출판사의 총 개수
```sql
SELECT COUNT(DISTINCT PUBLISHER)
FROM BOOK
```
COUNT(DISTINCT PUBLISHER)
--|
6
    
(3) 모든 고객의 이름, 주소
```sql
SELECT NAME, ADDRESS
FROM CUSTOMER
```
NAME|ADDRESS
--|--
박지성	|영국 맨체스타
김연아	|대한민국 서울
장미란	|대한민국 강원도
추신수	|미국 클리블랜드
박세리	|대한민국 대전

(4) 2014년 7월 4일~7월 7일 사이에 주문받은 도서의 주문번호
```sql
SELECT BOOKID
FROM ORDERS
WHERE ORDERDATE BETWEEN '2014 07 04' AND '2014 07 07'
```
BOOKID
--|
6
7
2
8

(5) 2014년 7월 4일~7월 7일 사이에 주문받은 도서를 제외한 도서의 주문번호
```sql
SELECT BOOKID
FROM ORDERS
WHERE ORDERDATE NOT BETWEEN '2014 07 04' AND '2014 07 07'
```
BOOKID
--|
1
3
5
10
10
8
    
(6) 성이 ‘김’ 씨인 고객의 이름과 주소
```sql
SELECT NAME, ADDRESS
FROM CUSTOMER    
WHERE NAME LIKE '김%'
```
NAME|ADDRESS
--|--
김연아	|대한민국 서울

(7) 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
```sql
SELECT NAME, ADDRESS
FROM CUSTOMER    
WHERE NAME LIKE '김%아'
```
NAME | ADDRESS
--|--
김연아	|대한민국 서울

(8) 주문하지 않은 고객의 이름(조인 사용)
```sql
SELECT NAME
FROM CUSTOMER
WHERE NAME NOT IN
(SELECT NAME
FROM ORDERS, CUSTOMER
WHERE ORDERS.CUSTID = CUSTOMER.CUSTID)
```
NAME
--|
박세리

(9) 주문 금액의 
```sql
SELECT SUM(SALEPRICE), AVG(SALEPRICE)
FROM ORDERS
```
SUM(SALEPRICE)_ AVG(SALEPRICE)
--|--
118000|11800

(10) 고객의 이름과 고객별 구매액
```sql
SELECT NAME, SUM(SALEPRICE)
FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
GROUP BY NAME
```
NAME | SUM(SALEPRICE)
--|--
박지성|39000
김연아	|15000
장미란	|31000
추신수	|33000

(11) 고객의 이름과 고객이 구매한 도서 목록
```sql
SELECT NAME, BOOKNAME
FROM CUSTOMER, ORDERS, BOOK
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
AND ORDERS.BOOKID = BOOK.BOOKID
```
NAME | BOOKNAME
--|--
박지성|	축구의 역사
박지성	|축구아는 여자
박지성	|축구의 이해
김연아	|피겨 교본
장미란	|역도 단계별기술
추신수	|야구의 추억
장미란	|야구를 부탁해
추신수	|야구를 부탁해
김연아	|Olympic Champions
장미란	|Olympic Champions


(12)도서의 가격(BOOK 테이블)과 판매가격(ORDERS 테이블)의 차이가 가장 많은 주문
```sql
SELECT *
FROM BOOK, ORDERS
WHERE BOOK.BOOKID = ORDERS.BOOKID
AND PRICE-SALEPRICE = 
(SELECT MAX(PRICE-SALEPRICE)
FROM BOOK, ORDERS
WHERE BOOK.BOOKID = ORDERS.BOOKID)
```
BOOKID | BOOKNAME| PUBLISHER| PRICE| ORDERID| CUSTID| BOOKID_1 |SALEPRICE| ORDERDATE
--|--|--|--|--|--|--|--|--
10	|Olympic Champions	|Pearson	|13000	|9	|2	|10	|7000	|14/07/09


(13)도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
```sql
SELECT NAME, AVG(SALEPRICE)
FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
GROUP BY NAME
HAVING AVG(SALEPRICE) >
(SELECT AVG(SALEPRICE)
FROM ORDERS)
```
NAME|AVG(SALEPRICE)
--|--
박지성	|13000
추신수	|16500
