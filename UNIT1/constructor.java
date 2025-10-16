package constructor;
class Student {
    String name;
    int age;

    // Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class constructor {
    public static void main(String[] args) {
        // Create object using constructor
        Student s1 = new Student("Hari", 20);
        s1.display();
    }
}
