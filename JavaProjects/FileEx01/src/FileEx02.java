import java.io.File;
import java.util.Arrays;

public class FileEx02 {
    public static void main(String[] args) {
        File dir = new File("c:/java");

        String[] lists = dir.list();
//        System.out.println(Arrays.toString(lists));

        for (String list : lists) {
            System.out.println(list);
        }

        //디렉토리만 [] 안에 출력
        for (String list : lists) {
//            System.out.println(list);
            File subdir = new File("c:/java", list);
            if (subdir.isDirectory()) {
                System.out.println("[" + list + "]");
            } else{
                System.out.println(list);
            }
        }

        File[] listFile = dir.listFiles();

        for (File file : listFile) {
            System.out.println(file.getName());
        }

    }
}
