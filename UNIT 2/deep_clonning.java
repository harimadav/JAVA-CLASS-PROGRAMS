package clonning;

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Student implements Cloneable {
    int id;
    Address addr;

    Student(int id, String city) {
        this.id = id;
        this.addr = new Address(city);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow cloning
    }
}

public class deep_clonning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student(101, "Chennai");
        Student s2 = (Student) s1.clone();

        s2.addr.city = "Bangalore"; // change in cloned object

        System.out.println("Original city: " + s1.addr.city); // Bangalore
        System.out.println("Cloned city:   " + s2.addr.city); // Bangalore
    }
}

