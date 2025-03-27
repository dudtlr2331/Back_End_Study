package exam;

public class CalculatorEx {
    public static void main(String[] args) {
        if ( args.length != 3 ) {
            System.out.println("Usage: java CalculatorEx01 num1 open num2");
        } else {
            // 2 + 2
            int value1 = Integer.parseInt( args[0] );
            int value2 = Integer.parseInt( args[2] );

            if ( args[1].equals( "+" )) {
                System.out.println( "결과 : " + ( value1 + value2 ) );
            } else if ( args[1].equals( "-" )) {
                System.out.println( "결과 : " + ( value1 - value2 ) );
            }
        }
    }
}
