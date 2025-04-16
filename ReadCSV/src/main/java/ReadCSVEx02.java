import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ReadCSVEx02 {
    public static void main(String[] args) {

        try {
            List<Member> members = new CsvToBeanBuilder<Member>(new FileReader("./data.csv"))
                    .withType( Member.class )
                    .build()
                    .parse();

            for ( Member member : members) {
                System.out.println(member.getName() + "\t" + member.getAge() );
            }

        } catch (FileNotFoundException e) {
            System.out.println( "[에러] " + e.getMessage() );
        }
    }
}