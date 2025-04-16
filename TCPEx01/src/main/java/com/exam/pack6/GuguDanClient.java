package com.exam.pack6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GuguDanClient {
    public static void main(String[] args) {
        System.out.println("클라이언트 시작");

        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            System.out.println("서버와 연결 시작");
            socket = new Socket("localhost", 7777);
            System.out.println("서버와 연결 성공");

            Scanner sc = new Scanner(System.in);
            System.out.print("구구단 단수 입력 : ");
            String dan = sc.nextLine();

            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            bw.write(dan + System.lineSeparator());
            bw.flush();
            System.out.println("전송 완료");

            String msg = br.readLine();
            String[] gugudan = msg.split(":");

            for (int i = 0; i < gugudan.length; i++) {
                System.out.println(gugudan[i]);
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (bw != null) try { bw.close(); } catch (IOException e) {}
            if (br != null) try { br.close(); } catch (IOException e) {}
            if (socket != null) try { socket.close(); } catch (IOException e) {}
        }

    }
}
