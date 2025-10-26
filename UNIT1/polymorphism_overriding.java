package polymorphsim;

//Parent class
class Animal {
 void sound() {
     System.out.println("Animals make sounds");
 }
}

//Child class
class Dog extends Animal {
 @Override
 void sound() {   // overriding the parent class method
     System.out.println("Dog barks");
 }
}

//Another Child class
class Cat extends Animal {
 @Override
 void sound() {
     System.out.println("Cat meows");
 }
}

public class polymorphism_overriding {
 public static void main(String[] args) {
     Animal a;   // reference of parent class

     a = new Dog();  
     a.sound();   // Calls Dog's overridden method

     a = new Cat();
     a.sound();   // Calls Cat's overridden method
 }
}
