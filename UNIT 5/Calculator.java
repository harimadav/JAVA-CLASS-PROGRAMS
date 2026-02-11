import javax.swing.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");

        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();

        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");

        JLabel result = new JLabel("Result:");

        num1.setBounds(50, 50, 100, 30);
        num2.setBounds(170, 50, 100, 30);

        add.setBounds(50, 100, 50, 30);
        sub.setBounds(110, 100, 50, 30);
        mul.setBounds(170, 100, 50, 30);
        div.setBounds(230, 100, 50, 30);

        result.setBounds(50, 150, 200, 30);

        add.addActionListener(e -> 
            result.setText("Result: " +
                (Double.parseDouble(num1.getText()) +
                 Double.parseDouble(num2.getText())))
        );

        sub.addActionListener(e -> 
            result.setText("Result: " +
                (Double.parseDouble(num1.getText()) -
                 Double.parseDouble(num2.getText())))
        );

        mul.addActionListener(e -> 
            result.setText("Result: " +
                (Double.parseDouble(num1.getText()) *
                 Double.parseDouble(num2.getText())))
        );

        div.addActionListener(e -> 
            result.setText("Result: " +
                (Double.parseDouble(num1.getText()) /
                 Double.parseDouble(num2.getText())))
        );

        frame.add(num1);
        frame.add(num2);
        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        frame.add(result);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
