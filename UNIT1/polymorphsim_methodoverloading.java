package polymorphsim;

class Calculator {
    // Method 1: Add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: Add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: Add two doubles
    double add(double a, double b) {
        return a + b;
    }
}

public class polymorphsim_methodoverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Calling different add() methods
        System.out.println("Sum of 2 integers: " + calc.add(5, 10));
        System.out.println("Sum of 3 integers: " + calc.add(2, 4, 6));
        System.out.println("Sum of 2 doubles: " + calc.add(3.5, 4.2));
    }
}

