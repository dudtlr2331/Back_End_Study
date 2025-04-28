package com.exam.pack1;

import java.io.IOException;
import java.net.Socket;

public class TCPClientEx {
    public static void main(String[] args) {
        System.out.println("클라이언트 시작");

        Socket socket = null;

        try {
            System.out.println("서버와 연결 시작");

            socket = new Socket("localhost", 7777);
            System.out.println("서버와 연결 성공");

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (socket != null) try { socket.close(); } catch (IOException e) {}
        }


        System.out.println("클라이언트 끝");
    }
}
