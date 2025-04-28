package io1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamEx01 {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("./object1.dat"));

            String[] names = {"홍길동", "임꺽정", "장길산"};
            int[] ages = {18, 18, 18};
            double[] weights = {78.5, 61.8, 81.8};

            oos.writeObject(names);
            oos.writeObject(ages);
            oos.writeObject(weights);

            System.out.println("출력 완료");
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (oos != null) try { oos.close(); } catch (IOException e) { }
        }
    }
}
