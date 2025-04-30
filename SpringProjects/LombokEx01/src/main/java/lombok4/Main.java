package lombok4;

public class Main {
    public static void main(String[] args) {
        DeptTO1 to1 = new DeptTO1("10", "생산부", "부산");
        System.out.println(to1.toString());

        DeptTO2 to2 = new DeptTO2("10", "생산부", "부산");
        System.out.println(to2.toString());


    }
}
