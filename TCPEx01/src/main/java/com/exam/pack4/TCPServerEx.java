package com.exam.pack4;

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
            //대기 중인 포트번호
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");

            //서버로의 요청 대기 중
            socket = serverSocket.accept();
            System.out.println("클라이언트와 연결되었습니다.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

            String msg = br.readLine();

            System.out.println("클라이언트가 보낸 메시지 : " + msg);

            bw.write(msg + System.lineSeparator());
            bw.flush(); // 비워줘

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
            if (bw != null) try { bw.close(); } catch (IOException e) {}
            if (socket != null) try { socket.close(); } catch (IOException e) {}
            if (serverSocket != null) try { serverSocket.close(); } catch (IOException e) {}
        }

        System.out.println("서버 끝");
    }
}
