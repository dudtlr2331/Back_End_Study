package com.exam.pack5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx {
    public static void main(String[] args) {
        System.out.println("서버 시작");

        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            serverSocket = new ServerSocket(7777);

            while (true) {
                try {
                    System.out.println("서버가 준비되었습니다.");

                    socket = serverSocket.accept();
                    System.out.println("클라이언트와 연결되었습니다.");

                    br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

                    String msg = br.readLine();

                    System.out.println("클라이언트가 보낸 메시지 : " + msg);

                    bw.write(msg + System.lineSeparator());
                    bw.flush(); // 비워줘

                    System.out.println("전송 완료");
                } catch (IOException e) {
                    System.out.println("[에러] " + e.getMessage());
                } finally {
                    if (br != null) try { br.close(); } catch (IOException e) {}
                    if (bw != null) try { bw.close(); } catch (IOException e) {}
                    if (socket != null) try { socket.close(); } catch (IOException e) {}
                }
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (serverSocket != null) try { serverSocket.close(); } catch (IOException e) {}
        }

        System.out.println("서버 끝");
    }
}
