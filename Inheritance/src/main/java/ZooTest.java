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

    @Override
    void eat() {
        System.out.println("사자가 고기를 먹습니다.");
    }
}

class Elephant extends Animal{
    void sprayWater(){
        System.out.println("코끼리가 물을 뿌립니다.");
    }

    @Override
    void eat() {
        System.out.println("코끼리가 물을 마십니다.");;
    }
}

class Penguin extends Animal{
    void swim(){
        System.out.println("펭귄이 수영합니다.");
    }

    @Override
    void eat() {
        System.out.println("펭귄이 생선을 먹습니다.");
    }
}

public class ZooTest {
    public static void main(String[] args) {
        Lion lion = new Lion();
        lion.eat();
        lion.sleep();
        lion.roar();

        Penguin penguin = new Penguin();
        penguin.eat();
        penguin.sleep();
    }
}
