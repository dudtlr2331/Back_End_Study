select empno, ename, sal '����޿�',
case deptno
	when 10 then sal * 1.1
	when 20 then sal * 1.2
	else sal
	end '�λ�޿�'
from emp;