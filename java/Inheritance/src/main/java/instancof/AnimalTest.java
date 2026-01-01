package instancof;

class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    void speak() {
        System.out.println(name + "이(가) 소리를 냅니다.");
    }
}

class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    void speak() {
        System.out.println(name + " (품종: " + breed + ")이(가) 멍멍 짖습니다.");
    }
}

class Cat extends Animal {
    int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    void speak() {
        System.out.println(name + " (나이: " + age + "살)이(가) 야옹 울어요.");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal dog =  new Dog("강아지", "진돗개");
//        Animal cat = new Cat("고양이", 3);

        Animal[] animals = {
                new Dog("강아지", "진돗개"),
                new Cat("고양이", 3)
        };

        for (Animal animal : animals) {
            animal.speak();
        }
    }
}
