SELECT e.empno,
	   e.ename,
	   e.sal,
	   d.dname,
	   d.loc,
	   s.grade
FROM emp e
INNER JOIN dept d
INNER JOIN salgrade s
ON e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal;