package com.exam.pack4;

import java.io.*;
import java.net.Socket;

public class TCPClientEx {
    public static void main(String[] args) {
        System.out.println("클라이언트 시작");

        Socket socket = null;

        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            System.out.println("서버와 연결 시작");

            socket = new Socket("localhost", 7777);
            System.out.println("서버와 연결 성공");

            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            bw.write("안녕 서버" + System.lineSeparator());
            bw.flush();
            // 서버로 보내는 파트

            System.out.println("전송 완료");

            String msg = br.readLine();
            System.out.println("서버에서 보낸 메시지 : " + msg);

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (bw != null) try { bw.close(); } catch (IOException e) {}
            if (br != null) try { br.close(); } catch (IOException e) {}
            if (socket != null) try { socket.close(); } catch (IOException e) {}
        }


        System.out.println("클라이언트 끝");
    }
}
