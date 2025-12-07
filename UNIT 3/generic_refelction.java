package GENERIC;
import java.lang.reflect.Method;

//Unbounded generic class
class Box<T> {
 T value;

 Box(T value) {
     this.value = value;
 }

 void show() {
     System.out.println("Value: " + value);
 }
}

public class generic_refelction {
 public static void main(String[] args) throws Exception {
     Box<String> b = new Box<>("Hello");

     // 1️⃣ Get the class object at runtime
     Class<?> cls = b.getClass();
     System.out.println("Class Name: " + cls.getName());

     // 2️⃣ Get the 'show' method object
     Method method = cls.getMethod("show");

     // 3️⃣ Invoke the 'show' method dynamically
     method.invoke(b);
 }
}


