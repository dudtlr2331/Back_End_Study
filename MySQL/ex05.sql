select ename, sal, job,
	case job
	when 'analyst' then '����'
	when 'clerk' then '���'
	when 'manager' then '����'
	when 'president' then '��ǥ'
	else '����'
	end '�ѱ۸� ǥ��'
from emp
where deptno = 30;