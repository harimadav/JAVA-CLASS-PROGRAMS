package GENERIC;

//Bounded generic class
class Box<T extends Number> {
 T value;

 Box(T value) {
     this.value = value;
 }

 void show() {
     System.out.println("Value: " + value);
 }
}

public class bound_generic {
 public static void main(String[] args) {
     Box<Integer> b1 = new Box<>(10);     // Integer
     b1.show();

     Box<Double> b2 = new Box<>(15.5);    // Double
     b2.show();

     // Box<String> b3 = new Box<>("Hello"); // ❌ Not allowed
 }
}
