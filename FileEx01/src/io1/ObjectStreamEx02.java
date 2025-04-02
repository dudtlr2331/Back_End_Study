package io1;

import java.io.*;
import java.util.Arrays;

public class ObjectStreamEx02 {
    public static void main(String[] args) {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("./object1.dat"));

            String[] names = (String[]) ois.readObject();
            int[] ages = (int[]) ois.readObject();
            double[] weights = (double[]) ois.readObject();

            System.out.println(Arrays.toString(names));
            System.out.println(Arrays.toString(ages));
            System.out.println(Arrays.toString(weights));


            System.out.println("출력완료");
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (ois != null) try { ois.close(); } catch (IOException e) { }
        }

    }
}
