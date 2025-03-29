interface InterA {
    void viewInner();
}
class ClassA implements InterA {
    @Override
    public void viewInner() {
        // TODO Auto-generated method stub
        System.out.println( "viewInner 호출" );
    }
}
public class InnerEx04 {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        a.viewInner();
        //익명 내부 객체
        new InterA() {
            public void viewInner() {
                System.out.println( "viewInner 호출 2" );
            };
        }.viewInner();
        InterA ia = new InterA() {
            @Override
            public void viewInner() {
                // TODO Auto-generated method stub
                System.out.println( "viewInner 호출 3" );
            }
        };
        ia.viewInner();
    }
}