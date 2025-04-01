import java.util.Calendar;

public class WeekEx01 {
    public static void main(String[] args) {
        Week today = null;

        Calendar cal = Calendar.getInstance();

        int week = cal.get(Calendar.WEEK_OF_YEAR);

        switch (week){
            case 1: today = Week.SATURDAY; break;
            case 2: today = Week.SUNDAY; break;
            case 3: today = Week.MONDAY; break;
            case 4: today = Week.TUESDAY; break;
            case 5: today = Week.WEDNESDAY; break;
            case 6: today = Week.THURSDAY; break;
            case 7: today = Week.FRIDAY; break;
        }

        if(today == Week.SUNDAY){
            System.out.println("일요일에는 축를 합니다.");
        }else {
            System.out.println("열심히 자바를 공부합니다.");
        }
    }
}
