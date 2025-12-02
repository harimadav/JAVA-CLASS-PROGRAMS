package refelection;


class Student {
    public String name = "Hari";

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }
}

public class refelection  {
    public static void main(String[] args) {
        try {
            // Get the class object
            Class<?> cls = Student.class;

            // Print the class name
            System.out.println("Class Name: " + cls.getName());

            // List all methods
            System.out.println("Methods:");
            for (var m : cls.getDeclaredMethods()) {
                System.out.println(m.getName());
            }

            // Create object dynamically
            Student s = (Student) cls.getDeclaredConstructor().newInstance();

            // Call method dynamically
            cls.getMethod("sayHello").invoke(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
