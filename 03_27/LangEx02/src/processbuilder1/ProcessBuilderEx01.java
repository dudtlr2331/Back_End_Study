package processbuilder1;

import java.io.IOException;

public class ProcessBuilderEx01 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb
//                = new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", "www.naver.com");\
        = new ProcessBuilder("C:\\Windows\\System32\\mspaint");
        pb.start();
    }
}
