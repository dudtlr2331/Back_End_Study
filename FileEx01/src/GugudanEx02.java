import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GugudanEx02 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try{
            br = new BufferedReader( new InputStreamReader( System.in ) );

            while (true) {
                System.out.print("단수 > ");
                String dan = br.readLine();

                if (dan.equals("0")) {
                    System.out.println("프로그램 종료");
                    break;
                }

                int intToDan = Integer.parseInt(dan);

                for (int i = 1; i <= 9; i++) {
                    System.out.printf("%d X %d = %d", intToDan, i, (intToDan * i ));
                    System.out.println();
                }
            }

        }catch(IOException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( br != null ) try { br.close(); } catch( IOException e ) {}
        }


    }
}
