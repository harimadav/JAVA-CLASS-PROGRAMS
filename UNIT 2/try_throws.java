package excepetion_handling;

public class try_throws {

    static void checkAge(int age) throws ArithmeticException {
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15); // age = 15 (below 18)
        } catch (ArithmeticException e) {
            System.out.println("Exception handled: " + e.getMessage());
        }

        System.out.println("Program continues normally...");
    }
}

