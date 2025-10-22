//Parent class
package innherintance;

class Animal {
 void sound() {
     System.out.println("Animals make sounds");
 }
}

//Child class of Animal
class Dog extends Animal {
 void bark() {
     System.out.println("Dog barks");
 }
}

//Child class of Dog (grandchild of Animal)
class Puppy extends Dog {
 void weep() {
     System.out.println("Puppy weeps");
 }
}

public class  inherritnace_mulitllevel {
 public static void main(String[] args) {
     Puppy p = new Puppy();

     // From Animal
     p.sound();

     // From Dog
     p.bark();

     // From Puppy
     p.weep();
 }
}

