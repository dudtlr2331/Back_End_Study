package com.exam.pack3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx {
    public static void main(String[] args) {
        System.out.println("서버 시작");

        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedReader br = null;

        try {
            //대기 중인 포트번호
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");

            //서버로의 요청 대기 중
            socket = serverSocket.accept();
            System.out.println("클라이언트와 연결되었습니다.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            System.out.println("전송 메시지 : " + br.readLine());

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
            if (socket != null) try { socket.close(); } catch (IOException e) {}
            if (serverSocket != null) try { serverSocket.close(); } catch (IOException e) {}
        }

        System.out.println("서버 끝");
    }
}
