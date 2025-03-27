package string1;

public class StringBuilderEx01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder( "Hello World!" );
        StringBuilder sb2 = new StringBuilder(100);
        StringBuilder sb3 = new StringBuilder("Hello StringBuilder");

        System.out.println(sb2.capacity());
        System.out.println(sb3.capacity());

        System.out.println(sb3.length());

        System.out.println(sb3);
        sb3.append("안녕");
        System.out.println(sb3);
        sb3.insert(3, "추가");
        sb3.delete(0, 4);



    }
}
