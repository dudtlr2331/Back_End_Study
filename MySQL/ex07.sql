select empno, ename, job, sal '����޿�',
case job
	when 'analyst' then sal * 1.1
	when 'clerk' then sal * 1.5
	when 'manager' then sal * 1.2
	when 'salesman' then sal * 1.3
	else sal
	end '�λ�޿�'
from emp;