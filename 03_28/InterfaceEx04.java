interface Vehicle{
    void run();
}

class Bus implements Vehicle{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("버스가 달립니다.");
    }

    public void checkFare(){
        System.out.println("승차요금을 체크합니다.");
    }
}

public class InterfaceEx04 {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
        // vehicle.checkFare();

        //강제형변환
        Bus bus = (Bus)vehicle;
        bus.run();
        bus.checkFare();
    }
}
