interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

class AnimalFactory {
    public static Animal getAnimal(String type) {
        if ("dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("cat".equalsIgnoreCase(type)) {
            return new Cat();
        } else {
            throw new IllegalArgumentException("Unknown animal type");
        }
    }
}

public class AnimallFactory {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getAnimal("dog");
        dog.sound();

        Animal cat = AnimalFactory.getAnimal("cat");
        cat.sound();
    }
}
