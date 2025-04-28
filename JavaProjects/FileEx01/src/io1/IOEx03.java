package io1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx03 {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("./data2.txt");
        }catch (FileNotFoundException e){
            System.out.println("[에러] " + e.getMessage());
        }finally {
            try{ fos.close();}catch (IOException e){}
        }
    }
}
