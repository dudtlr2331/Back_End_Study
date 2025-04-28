import java.io.IOException;

public class ExceptionEx10 {
    public static void main(String[] args) {
        try{
            ProcessBuilder processBuilder
                    = new ProcessBuilder("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
            processBuilder.start();
        }catch (IOException e){
            System.out.println("[에러] " + e.getMessage());
        }

        try {
            ProcessBuilder processBuilder
                    = new ProcessBuilder("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
            processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
