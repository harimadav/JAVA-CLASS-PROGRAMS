package java_collections;
import java.util.LinkedHashSet;

public class set_linkedhastagset {
  public static void main(String[] args) {
    LinkedHashSet<String> cars = new LinkedHashSet<>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("BMW");  // Duplicate
    cars.add("Mazda");

    System.out.println(cars);
  }
}

