package GENERIC;

class Box<T> {
 T value;

 Box(T value) {
     this.value = value;
 }

 void show() {
     System.out.println("Value: " + value);
 }

 // Generic method inside the class
 public <U> void showGeneric(U data) {
     System.out.println("Generic Value: " + data);
 }
}

public class generic_method  {
 public static void main(String[] args) {
     Box<Integer> b = new Box<>(50);
     b.show();               // Normal method
     b.showGeneric("Hello"); // Generic method with String
     b.showGeneric(99.9);    // Generic method with Double
 }
}


