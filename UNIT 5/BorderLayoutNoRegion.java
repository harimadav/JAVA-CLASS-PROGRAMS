package unit5_exam;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutNoRegion {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Without Region");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        // Adding buttons without specifying regions
        frame.add(new JButton("Button 1"));
        frame.add(new JButton("Button 2"));
        frame.add(new JButton("Button 3"));

        frame.setVisible(true);
    }
}
