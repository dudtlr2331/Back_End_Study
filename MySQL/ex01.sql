select concat(empno, ' 사원번호인 사원 ', ename, '의 입사일은 ', date_format(hiredate, '%Y년 %m월 %d일 이다.'))
from emp
where deptno = 30; 