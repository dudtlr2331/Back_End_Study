package io1;

import java.io.*;

public class DataStreamEx02 {
    public static void main(String[] args) {
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(new FileInputStream("./data.txt"));

            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
            System.out.println(dis.readFloat());

            System.out.println("출력 완료");
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if(dis != null) try{ dis.close(); } catch(Exception e){}
        }
    }
}
