package lombok2;

public class Main {
    public static void main(String[] args) {
        DeptTO2 to21 = new DeptTO2();
        DeptTO2 to22 = new DeptTO2("20", "연구부", "대전");

        System.out.println(to22.getDeptno());
        System.out.println(to22.getDname());
        System.out.println(to22.getLoc());

        DeptTO3 to3 = new DeptTO3("30", "개발부");

        System.out.println(to3.getDeptno());
        System.out.println(to3.getDname());
        System.out.println(to3.getLoc());

    }
}
