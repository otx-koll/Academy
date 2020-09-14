### NULL값
- 아직 지정되지 않은 값
- NULL 값은 '0', '(빈 문자)', '(공백)' 등과 다른 특별한 값이다.
- NULL값은 비교 연산자로 비교가 불가능하다
- NULL 값의 연산을 수행하면 결과 역시 NULL값으로 반환

#### NVL
- NULL값을 다른 값으로 대치하여 연산하거나 다른 값으로 출력
```sql
NVL(속성, 값) // 속성 값이 NULL이면 '값'으로 대치한다.
```
```sql
NVL2(속성, 값1, 값2) // 속성 값이 NULL값이 아니면 값1, NULL값이면 값2
```

예1) NVL 함수 퀴즈

professor 테이블에서 201번 학과(deptno) 교수들의 교수번호, 이름과 급여, bonus, 총 연봉을 total로 출력하라. 총 연봉은 (pay*12+bonus)로 계산하고 bonus가 없는 교수는 0으로 계산하라
```sql
SELECT PROFNO
     , NAME
     , PAY
     , BONUS
     , TO_CHAR((PAY*12+NVL(BONUS,0)),'99,999') "TOTAL"
FROM PROFESSOR
WHERE DEPTNO = 201
```
PROFNO | NAME | PAY | BONUS | TOAL
--|--|--|--|--
4001	|Meryl Streep	|570	|130	 | 6,970
4002	|Susan Sarandon	|330	|	  |3,960


예2) NVL2 함수 퀴즈

emp테이블에서 deptno가 30번인 사원들을 조회하여 comm값이 있을 경우 'Exist'를 출력하고 comm 값이 null일 경우 'NULL'을 출력하라
```sql
SELECT EMPNO
     , ENAME
     , COMM
     , NVL2(COMM, 'Exist', NULL) "NVL2"
FROM EMP
WHERE DEPTNO = 30;
```
EMPNO | ENAME | COMM | NVL2
--|--|--|--
7499	|ALLEN	|300	|Exist
7521	|WARD	|500	|Exist
7654	|MARTIN	|1400	|Exist
7698	|BLAKE	|	
7844	|TURNER	|0	|Exist
7900	|JAMES		
