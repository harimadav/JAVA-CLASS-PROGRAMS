// Parent class
package innherintance;

class Animal {
    void sound() {
        System.out.println("Animals make sounds");
    }
}

// Child class inherits from Animal
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class inherritance_simple{
    public static void main(String[] args) {
        Animal a = new Animal();  // object of parent
        a.sound();

        Dog d = new Dog();        // object of child
        d.sound();
    }
}

