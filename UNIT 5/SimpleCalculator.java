import javax.swing.*;
import java.awt.event.*;

public class SimpleCalculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");

        JLabel l1 = new JLabel("Number 1:");
        l1.setBounds(30, 30, 80, 20);

        JLabel l2 = new JLabel("Number 2:");
        l2.setBounds(30, 70, 80, 20);

        JTextField t1 = new JTextField();
        t1.setBounds(120, 30, 100, 20);

        JTextField t2 = new JTextField();
        t2.setBounds(120, 70, 100, 20);

        JLabel result = new JLabel("Result:");
        result.setBounds(30, 150, 200, 20);

        JButton add = new JButton("+");
        add.setBounds(30, 110, 50, 25);

        JButton sub = new JButton("-");
        sub.setBounds(90, 110, 50, 25);

        JButton mul = new JButton("×");
        mul.setBounds(150, 110, 50, 25);

        JButton div = new JButton("÷");
        div.setBounds(210, 110, 50, 25);

        // Addition
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                result.setText("Result: " + (a + b));
            }
        });

        // Subtraction
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                result.setText("Result: " + (a - b));
            }
        });

        // Multiplication
        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                result.setText("Result: " + (a * b));
            }
        });

        // Division
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                if (b != 0)
                    result.setText("Result: " + (a / b));
                else
                    result.setText("Cannot divide by zero!");
            }
        });

        frame.add(l1);
        frame.add(l2);
        frame.add(t1);
        frame.add(t2);
        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        frame.add(result);

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
