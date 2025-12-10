// Unbounded generic class
package GENERIC;

class Box<T> {
    T value;

    Box(T value) {
        this.value = value;
    }

    void show() {
        System.out.println("Value: " + value);
    }
}

public class genericz_class_prog {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>(10);     // Integer
        b1.show();

        Box<String> b2 = new Box<>("Hello"); // String
        b2.show();
    }
}
