class Cal{
    public int sum(int a, int b){
        return a + b;
    }
}

class Cal3 extends Cal{
    public int minus(int a, int b){
        return a - b;
    }
}


public class TestApp {
    public static void main(String[] args) {
//        Cal cal = new Cal();
//        System.out.println(cal.sum(1, 2));
        Cal3 cal3 = new Cal3();
        System.out.println(cal3.sum(1, 2));
        System.out.println(cal3.minus(2, 1));
    }
}

class Cal2 {
    public int sum(int a, int b){
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }
}