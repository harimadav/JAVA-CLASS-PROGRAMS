package GENERIC;



//Generic parent class (unbounded)
class Box<T> {
 T value;

 Box(T value) {
     this.value = value;
 }

 void show() {
     System.out.println("Value: " + value);
 }
}

//Child class inherits from generic parent
class FancyBox<T> extends Box<T> {
 FancyBox(T value) {
     super(value);  // call parent constructor
 }

 void display() {
     System.out.println("Fancy Value: " + value);
 }
}

public class  generic_class_using_inheritance{
 public static void main(String[] args) {
     // Using Integer
     FancyBox<Integer> b1 = new FancyBox<>(100);
     b1.show();
     b1.display();

     // Using String
     FancyBox<String> b2 = new FancyBox<>("Hello");
     b2.show();
     b2.display();
 }
}


