class Outer {
    private int x1 = 100;
    public int x2 = 100;
    Outer() {
        System.out.println( "Outer : " + this );
    }
    static class Inner {
        private int y1 = 200;
        public int y2 = 200;
        Inner() {
            System.out.println( "Inner : " + this );
        }
        void viewInner() {
            //System.out.println( x1 );
            //System.out.println( x2 );
            System.out.println( y1 );
            System.out.println( y2 );
        }
    }
}
public class InnerEx02 {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        //System.out.println( inner.y1 );
        System.out.println( inner.y2 );
        inner.viewInner();
    }
}