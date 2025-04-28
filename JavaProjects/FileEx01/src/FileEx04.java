import java.io.File;
import java.io.IOException;

public class FileEx04 {
    public static void main(String[] args) {
        //파일

        File file1 = new File("C:/java/test1.txt");

        /*try {
            if(file1.createNewFile()){
                System.out.println("파일 생성 성공");
            } else{
                System.out.println("파일 생성 실패");
            }
        } catch (IOException e) {
            System.out.println("[에러]" + e.getMessage());
        }*/

        File file2 = new File("C:/java/test2.txt");
        /*if(file1.renameTo(file2)) {
            System.out.println("이름 변경 성공");
        } else {
            System.out.println("이름 변경 실패");
        }*/

        if(file2.delete()) {
            System.out.println("파일 삭제 성공");
        } else{
            System.out.println("파일 삭제 실패");
        }
    }
}
