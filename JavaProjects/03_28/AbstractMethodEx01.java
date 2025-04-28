public class AbstractMethodEx01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        animalSound(new Dog());
        animalSound(new Cat());
    }
        
    private static void animalSound(Animal animal) {
        animal.sound();
    }
}
