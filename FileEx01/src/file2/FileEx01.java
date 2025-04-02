package file2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx01 {
    public static void main(String[] args) {
        // 절대경로 , 상대경로
        // => File

        try {
            // 절대경로를 통해서 파일 / 디렉토리에 대한 File 클래스 생성
            File dir1 = new File("c:/git/Back_End_Study/FileEx01");
            System.out.println(dir1.getAbsoluteFile());
            System.out.println(dir1.getCanonicalPath());

            //상대 경로 : .(프로그램이 실행되는 현재 디렉토리)
            File dir2 = new File(".");
            System.out.println(dir2.getAbsoluteFile());
            System.out.println(dir2.getCanonicalPath());

            String[] lists = dir2.list();
            System.out.println(Arrays.toString(lists));

            File file = new File("./data.txt");
            System.out.println(file.exists());

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {

        }
    }
}
