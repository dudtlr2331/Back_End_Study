interface Tire{
    void roll();
}

class HankookTire implements Tire{
    @Override
    public void roll() {
        System.out.println("한국 타이어가 굴러갑니다.");
    }
}

class KumhoTire implements Tire{
    @Override
    public void roll() {
        System.out.println("금호 타이터가 굴러갑니다.");    
    }
    
}

class Car {
    Tire t1 = new HankookTire();
    Tire t2 = new KumhoTire();

    void run(){
        t1.roll();
        t2.roll();
    }
}

public class CarEx01 {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.run();

        myCar.t1 = new KumhoTire();
        myCar.t2 = new KumhoTire();

        myCar.run();
    }
}
