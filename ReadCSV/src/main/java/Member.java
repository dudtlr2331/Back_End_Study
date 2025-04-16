import com.opencsv.bean.CsvBindByName;

public class Member {
    @CsvBindByName
    private String name;
    @CsvBindByName
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}