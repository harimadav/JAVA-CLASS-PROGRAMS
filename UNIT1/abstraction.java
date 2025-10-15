package abstraction;

//Abstract class
abstract class Shape {
 // abstract method (no body)
 abstract void draw();

 // normal method
 void display() {
     System.out.println("This is a shape");
 }
}

//Child class 1
class Circle extends Shape {
 void draw() {
     System.out.println("Drawing a Circle");
 }
}

//Child class 2
class Rectangle extends Shape {
 void draw() {
     System.out.println("Drawing a Rectangle");
 }
}

public class abstraction {
 public static void main(String[] args) {
     Shape s;   // reference of abstract class

     s = new Circle();
     s.display();  // normal method
     s.draw();     // abstract method implemented in Circle

     s = new Rectangle();
     s.display();
     s.draw();
 }
}


