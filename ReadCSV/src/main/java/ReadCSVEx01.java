import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadCSVEx01 {
    public static void main(String[] args) {
        CSVReader csvReader = null;

        try {
            csvReader = new CSVReaderBuilder( new FileReader( "./data.csv") ).build();

            List<String[]> lines = csvReader.readAll();


            for (String[] line : lines) {
                System.out.println( line[0] + "\t" + line[1] );
            }

        } catch (FileNotFoundException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (CsvException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( csvReader != null ) try { csvReader.close(); } catch (IOException e) { }
        }
    }
}