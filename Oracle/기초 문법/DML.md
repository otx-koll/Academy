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
---
### 예제
1. 모든 도서의 이름과 가격을 검색하시오
`SELECT bookename, price FROM book;`

2. 도서 테이블에 있는 모든 출판사를 검색하시오(중복은 제거한다)
`SELECT DISTINCT publisher FROM book;`

3. 가격이 1000이상, 2000 이하인 도서를 검색하시오
`SELECT * FROM Book WHERE price BETWEEN 1000 AND 2000;`

4. 도서 이름의 왼쪽 두 번째 위치에 '구'라는 문자열을 갖는 도서 검색
`SELECT * FROM Book WHERE bookname LIKE '_구%'`

5. 도서를 가격의 내림차순으로 검색하시오. 가격이 같을시 출판사의 오름차순으로 검색

`SELECT * FROM Book ORDER BY price DESC, publisher ASC;`

6. 마당서점의 도서 판매 건수
`SELECT COUNT(*) FROM Orders;`

7. 
