package polymorphsim;

//Parent class
class Vehicle {
 void run() {
     System.out.println("Vehicle is running");
 }
}

//Child class 1
class Car extends Vehicle {
 @Override
 void run() {
     System.out.println("Car is running safely");
 }
}

//Child class 2
class Bike extends Vehicle {
 @Override
 void run() {
     System.out.println("Bike is running fast");
 }
}

public class polymorphism_dynamic_method_dispatch  {
 public static void main(String[] args) {
     Vehicle v;  // parent class reference
    
     v = new Car();   // reference -> Car object
     v.run();         // calls Car's run()

     v = new Bike();  // reference -> Bike object
     v.run();         // calls Bike's run()
 }
}

