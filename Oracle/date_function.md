- SYSDATE : 오늘 날짜

- MONTHS_BETWEEN
: 날짜와 날짜사이

: months_between('20/03/01','20/04/01') > -1


- ADD_MONTHS
: 달을 더함

> sysdate, add_months(sysdate, 1) > 20/08/14에서 20/09/14로 됨


- NEXT_DAY
: next_day('20/08/12','금') > 20/08/14

: 12일은 수요일인데 '금'으로 지정했기 때문에 14일로 바뀜


- LAST_DAY
: 지정한 달의 마지막 날짜

: last_day('19/11/11') > 19/11/30
