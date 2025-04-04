select e.empno,  e.ename, e.sal, s.grade
from emp e
inner join salgrade s
where e.sal >= s.losal and e.sal <= s.hisal;