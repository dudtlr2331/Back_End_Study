select empno, ename, sal '현재급여',
case deptno
	when 10 then sal * 1.1
	when 20 then sal * 1.2
	else sal
	end '인상급여'
from emp;