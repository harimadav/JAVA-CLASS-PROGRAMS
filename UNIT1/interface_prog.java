package interface_program;



//Interface
interface Animal {
void sound();   // abstract method (no body)
void sleep();   // abstract method
}

//Class implementing the interface
class Dog implements Animal {
public void sound() {
   System.out.println("Dog barks");
}

public void sleep() {
   System.out.println("Dog sleeps");
}
}

//Another class implementing the interface
class Cat implements Animal {
public void sound() {
   System.out.println("Cat meows");
}

public void sleep() {
   System.out.println("Cat sleeps");
}
}

public class interface_prog{
public static void main(String[] args) {
   Animal a;   // interface reference

   a = new Dog();  
   a.sound();
   a.sleep();

   a = new Cat();
   a.sound();
   a.sleep();
}
}
