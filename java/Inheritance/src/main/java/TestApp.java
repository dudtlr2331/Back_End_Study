class Animal{

    void eat(){
        System.out.println("동물이 먹습니다.");
    }

    void sleep(){
        System.out.println("동물이 잡니다.");
    }
}

class Lion extends Animal{
    void roar(){
        System.out.println("사자가 으르렁거립니다.");
    }
}

public class TestApp {
    public static void main(String[] args) {

    }
}
