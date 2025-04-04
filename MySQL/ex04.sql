-- select case 'analyst'
select case job
when 'analyst' then '조사'
when 'clerk' then '사원'
when 'manager' then '관리'
when 'president' then '대표'
else '영업'
end '한글명 표기'
from emp;