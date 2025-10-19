//Parent class
package innherintance;

class animal {
 void sound() {
     System.out.println("Animals make sounds");
 }
}

//Child class 1
class Dog extends animal {
 void bark() {
     System.out.println("Dog barks");
 }
}

//Child class 2
class Cat extends animal {
 void meow() {
     System.out.println("Cat meows");
 }
}

public class inherintance_hieracrachial  {
 public static void main(String[] args) {
     animal o = new animal();
	 Dog d = new Dog();
     d.sound();  // inherited from Animal
     d.bark();   // Dog's own method

     Cat c = new Cat();
     c.sound();  // inherited from Animal
     c.meow();   // Cat's own method
 }
}

