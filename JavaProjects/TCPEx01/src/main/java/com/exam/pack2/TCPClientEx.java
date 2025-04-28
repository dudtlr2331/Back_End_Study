package com.exam.pack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClientEx {
    public static void main(String[] args) {
        System.out.println("클라이언트 시작");

        Socket socket = null;

        BufferedReader br = null;

        try {
            System.out.println("서버와 연결 시작");

            socket = new Socket("localhost", 7777);
            System.out.println("서버와 연결 성공");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("전송 메시지 : " + br.readLine());

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
            if (socket != null) try { socket.close(); } catch (IOException e) {}
        }


        System.out.println("클라이언트 끝");
    }
}
