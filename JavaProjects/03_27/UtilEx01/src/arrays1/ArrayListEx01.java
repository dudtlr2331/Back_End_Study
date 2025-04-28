package arrays1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx01 {
    public static void main(String[] args) {
        // 생성
        ArrayList al1 = new ArrayList();
        ArrayList al2 = new ArrayList( 100 );

        List list1 = new ArrayList();
        //Object obj1 = new ArrayList();

        // add
        // "홍길동" -> Object -> al1
        al1.add( "홍길동" );
        Object obj = "박문수";
        al1.add( obj );
        al1.add( "임꺽정" );

        System.out.println( al1.size() );

        al1.add( "이몽룡" );

        System.out.println( al1.size() );
        //System.out.println( al1 );
        System.out.println( al1.toString() );

        Object obj1 = al1.get(0);
        Object obj2 = al1.get(1);
        Object obj3 = al1.get(2);

        System.out.println( (String) obj1 );
        System.out.println( (String) al1.get(1) );
        System.out.println( (String) al1.get(2) );

        //String str = al1.get(0);

        for ( int i=0 ; i<al1.size() ; i++ ) {
            System.out.println( (String) al1.get(i) );
        }

        for ( Object obj4 : al1 ) {
            System.out.println( (String)obj4 );
        }

    }
}