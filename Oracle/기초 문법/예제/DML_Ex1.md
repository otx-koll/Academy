#### 1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오
(1) 도서번호가 1인 도서의 이름
```
SELECT BOOKNAME
FROM BOOK
WHERE BOOKID = 1
```
BOOKNAME
-- |
축구의 역사

(2) 가격이 20,000원 이상인 도서의 이름
```
SELECT BOOKNAME
FROM BOOK
WHERE PRICE >= 20000
```
BOOKNAME
-- |
축구의 이해
골프 바이블
야구의 추억

(3) 박지성의 총 구매액
```
SELECT SUM(saleprice)
FROM ORDERS, CUSTOMER
WHERE ORDERS.CUSTID = CUSTOMER.CUSTID AND CUSTOMER.NAME = '박지성'
```
SUM(SALEPRICE)
--|
39000

(4) 박지성이 구매한 도서의 수
```
SELECT COUNT(*) FROM Customer, Orders
WHERE Customer.custid = Orders.custid
AND Customer.name LIKE '박지성'
```
COUNT(\*)
--|
3

(5) 박지성이 구매한 도서의 출판사 수
```
SELECT COUNT(publisher)
FROM Customer, Orders, Book
WHERE Customer.custid = Orders.custid AND Orders.bookid = Book.bookid AND Customer.name LIKE '박지성'
```


#### 2. 마당서점의 운영자가 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오

(1) 마당서점 도서의 총 개수
```
SELECT COUNT(*)
FROM BOOK
```
    
(2) 마당서점에 도서를 출고하는 출판사의 총 개수
```
SELECT COUNT(DISTINCT PUBLISHER)
FROM BOOK
```
    
(3) 모든 고객의 이름, 주소
```
SELECT NAME, ADDRESS
FROM CUSTOMER
```

(4) 2014년 7월 4일~7월 7일 사이에 주문받은 도서의 주문번호
```
SELECT BOOKID
FROM ORDERS
WHERE ORDERDATE BETWEEN '2014 07 04' AND '2014 07 07'
```
(5) 2014년 7월 4일~7월 7일 사이에 주문받은 도서를 제외한 도서의 주문번호
```
SELECT BOOKID
FROM ORDERS
WHERE ORDERDATE NOT BETWEEN '2014 07 04' AND '2014 07 07'
```
    
(6) 성이 ‘김’ 씨인 고객의 이름과 주소
```
SELECT NAME, ADDRESS
FROM CUSTOMER    
WHERE NAME LIKE '김%'
```

(7) 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
```
SELECT NAME, ADDRESS
FROM CUSTOMER    
WHERE NAME LIKE '김%아'
```
