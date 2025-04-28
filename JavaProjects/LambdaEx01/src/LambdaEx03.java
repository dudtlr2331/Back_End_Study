public class LambdaEx03 {
    public static void main(String[] args) {
        Workable w = () -> {
            System.out.println("출근합니다.");
        };

        w.work();

        Person p = new Person();
        p.action(() -> {
            System.out.println("출근합니다.");
            System.out.println("프로그래밍합니다.");
        });

        p.action(() -> System.out.println("출근합니다."));
    }
}
