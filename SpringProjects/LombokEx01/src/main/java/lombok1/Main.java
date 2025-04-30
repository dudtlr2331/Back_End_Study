package lombok1;

public class Main {
    public static void main(String[] args) {
        DeptTO1 to1 = new DeptTO1();
        to1.setDeptno("10");
        to1.setDname("생산부");
        to1.setLoc("부산");

        System.out.println( to1.getDeptno());
        System.out.println( to1.getDname());
        System.out.println( to1.getLoc());

        DeptTO2 to2 = new DeptTO2();
        to2.setDeptno("20");
        to2.setDname("연구부");
        to2.setLoc("서울");

        System.out.println( to2.getDeptno());
        System.out.println( to2.getDname());
        System.out.println( to2.getLoc());
    }
}
