import java.io.File;

public class FileEx03 {
    public static void main(String[] args) {
        //디렉토리 생성
        File dir1 = new File("C:/java/dir1");

        /*if (dir1.mkdir()){
            System.out.println("생성 성공");
        }else {
            System.out.println("생성 실패");
        }*/
        //디렉토리 이름 변경
        File dir2 = new File("C:/java/dir2");
       /* if(dir1.renameTo(dir2)) {
            System.out.println("이름 변경 성공");
        }else {
            System.out.println("이름 변경 실패");
        }*/

        //디렉토리 삭제
        if(dir2.delete()) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }
}
