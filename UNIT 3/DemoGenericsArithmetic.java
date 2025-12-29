import java.util.function.BinaryOperator;

class GenericsArithmetic<T> {
    private T number1, number2, sum, product, difference;

    public void AddNumbers(T number1, T number2, BinaryOperator<T> adder) {
        this.number1 = number1;
        this.number2 = number2;
        this.sum = adder.apply(number1, number2);
    }

    public T getSum() {
        return sum;
    }

    public void MultNumbers(T number1, T number2, BinaryOperator<T> multiplier) {
        this.number1 = number1;
        this.number2 = number2;
        this.product = multiplier.apply(number1, number2);
    }

    public T getProd() {
        return product;
    }

    public void subtractNumbers(T number1, T number2, BinaryOperator<T> subtractor) {
        this.number1 = number1;
        this.number2 = number2;
        this.difference = subtractor.apply(number1, number2);
    }

    public T getDifference() {
        return difference;
    }
}

public class DemoGenericsArithmetic {
    public static void main(String[] args) {
        // For Integer
        GenericsArithmetic<Integer> integerNumbers = new GenericsArithmetic<>();
        integerNumbers.AddNumbers(100, 200, (a, b) -> a + b);
        System.out.println("Integer Sum: " + integerNumbers.getSum());

        integerNumbers.MultNumbers(10, 5, (a, b) -> a * b);
        System.out.println("Integer Product: " + integerNumbers.getProd());

        integerNumbers.subtractNumbers(50, 30, (a, b) -> a - b);
        System.out.println("Integer Difference: " + integerNumbers.getDifference());

        // For Double
        GenericsArithmetic<Double> doubleNumbers = new GenericsArithmetic<>();
        doubleNumbers.AddNumbers(10.5, 20.3, (a, b) -> a + b);
        System.out.println("Double Sum: " + doubleNumbers.getSum());

        doubleNumbers.MultNumbers(2.5, 3.0, (a, b) -> a * b);
        System.out.println("Double Product: " + doubleNumbers.getProd());

        doubleNumbers.subtractNumbers(10.5, 5.2, (a, b) -> a - b);
        System.out.println("Double Difference: " + doubleNumbers.getDifference());
    }
}

