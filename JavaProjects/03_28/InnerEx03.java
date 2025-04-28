public class InnerEx03 {
    public static void main(String[] args) {
        // 지역변수
        int x = 100;
        // 선언
        class Inner {
            private int y1 = 200;
            public int y2 = 200;
            Inner() {
                System.out.println( "Inner : " + this );
            }
            public void viewInner() {
                System.out.println( y1 );
                System.out.println( y2 );
                // 읽기
                System.out.println( x );
                // 수정 불가능
                //x++;
                //System.out.println( x );
            }
        }
        // 생성과 사용
        Inner inner = new Inner();
        inner.viewInner();
    }
}