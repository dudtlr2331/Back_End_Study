package lombok2;

public class DeptTO1 {
    private String deptno;
    private String dname;
    private String loc;

    public DeptTO1() {

    }

    public DeptTO1(String deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
