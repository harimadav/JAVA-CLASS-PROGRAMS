import javax.swing.*;
import java.awt.event.*;

public class WelcomeSwing {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Swing Example");

        JButton btn = new JButton("Click Me");
        btn.setBounds(100, 50, 100, 30);

        JLabel label = new JLabel("");
        label.setBounds(100, 100, 200, 30);

        // Button Click Event
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Welcome to Java Swing!");
            }
        });

        frame.add(btn);
        frame.add(label);

        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
