import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class question_and_answer extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private int score = 0;
    private Timer timer;
    private int timeLeft;

    private JLabel timerLabelQ1;
    private JLabel timerLabelQ2;

    // Correct answers
    private final String correctCapital = "Delhi";
    private final boolean[] correctCrops = {true, true, false, false}; // Rice, Maize, Jute, Ragi

    public question_and_answer() {
        setTitle("Quiz Application");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.WHITE);

        // Create question panels
        JPanel q1Panel = createQuestion1Panel();
        JPanel q2Panel = createQuestion2Panel();

        mainPanel.add(q1Panel, "Q1");
        mainPanel.add(q2Panel, "Q2");

        add(mainPanel);
        setVisible(true);

        showQuestion("Q1"); // Start with Q1
    }

    private void startTimer(JLabel activeTimerLabel, String nextCard) {
        stopTimer();
        timeLeft = 60;

        timer = new Timer(1000, e -> {
            timeLeft--;
            activeTimerLabel.setText("Time left: " + timeLeft + "s");

            if (timeLeft <= 0) {
                ((Timer) e.getSource()).stop();
                JOptionPane.showMessageDialog(this, "Time's up!");
                if (nextCard.equals("Q2")) showQuestion("Q2");
                else showResult();
            }
        });
        timer.start();
    }

    private void stopTimer() {
        if (timer != null && timer.isRunning()) timer.stop();
    }

    private void showQuestion(String card) {
        cardLayout.show(mainPanel, card);
        if (card.equals("Q1")) startTimer(timerLabelQ1, "Q2");
        else if (card.equals("Q2")) startTimer(timerLabelQ2, "Result");
    }

    private JPanel createQuestion1Panel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Timer label top-right
        timerLabelQ1 = new JLabel("Time left: 60s", SwingConstants.RIGHT);
        timerLabelQ1.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.add(timerLabelQ1, BorderLayout.EAST);

        // Question content
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);

        JLabel questionLabel = new JLabel("1. What is the capital of India?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JRadioButton opt1 = new JRadioButton("Chennai");
        JRadioButton opt2 = new JRadioButton("Delhi");
        JRadioButton opt3 = new JRadioButton("Kolkata");
        JRadioButton opt4 = new JRadioButton("Mumbai");

        ButtonGroup group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        for (JRadioButton opt : new JRadioButton[]{opt1, opt2, opt3, opt4}) {
            opt.setBackground(Color.WHITE);
            opt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }

        JButton nextBtn = new JButton("Next");
        nextBtn.setFont(new Font("Arial", Font.BOLD, 14));
        nextBtn.setBackground(new Color(100, 150, 250));
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setFocusPainted(false);
        nextBtn.setAlignmentX(Component.LEFT_ALIGNMENT);

        nextBtn.addActionListener(e -> {
            stopTimer();
            String answer = "";
            if (opt1.isSelected()) answer = "Chennai";
            else if (opt2.isSelected()) answer = "Delhi";
            else if (opt3.isSelected()) answer = "Kolkata";
            else if (opt4.isSelected()) answer = "Mumbai";

            if (answer.equals(correctCapital)) score += 5;
            showQuestion("Q2");
        });

        content.add(questionLabel);
        content.add(Box.createVerticalStrut(10));
        content.add(opt1);
        content.add(opt2);
        content.add(opt3);
        content.add(opt4);
        content.add(Box.createVerticalStrut(20));
        content.add(nextBtn);

        panel.add(header, BorderLayout.NORTH);
        panel.add(content, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createQuestion2Panel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Timer label top-right
        timerLabelQ2 = new JLabel("Time left: 60s", SwingConstants.RIGHT);
        timerLabelQ2.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.add(timerLabelQ2, BorderLayout.EAST);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);

        JLabel questionLabel = new JLabel("2. List the crops available in all seasons in India:");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JCheckBox crop1 = new JCheckBox("Rice");
        JCheckBox crop2 = new JCheckBox("Maize");
        JCheckBox crop3 = new JCheckBox("Jute");
        JCheckBox crop4 = new JCheckBox("Ragi");

        JCheckBox[] crops = {crop1, crop2, crop3, crop4};
        for (JCheckBox c : crops) {
            c.setBackground(Color.WHITE);
            c.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 14));
        submitBtn.setBackground(new Color(100, 150, 250));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);

        submitBtn.addActionListener(e -> {
            stopTimer();
            int correctSelected = 0;
            if (crop1.isSelected() && correctCrops[0]) correctSelected++;
            if (crop2.isSelected() && correctCrops[1]) correctSelected++;

            if (correctSelected == 2) score += 5;
            else if (correctSelected == 1) score += 2;

            showResult();
        });

        content.add(questionLabel);
        content.add(Box.createVerticalStrut(10));
        for (JCheckBox c : crops) content.add(c);
        content.add(Box.createVerticalStrut(20));
        content.add(submitBtn);

        panel.add(header, BorderLayout.NORTH);
        panel.add(content, BorderLayout.CENTER);

        return panel;
    }

    private void showResult() {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        JLabel resultLabel = new JLabel("Your Total Score: " + score + "/10");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton viewAnswersBtn = new JButton("View Correct Answers");
        viewAnswersBtn.setFont(new Font("Arial", Font.BOLD, 14));
        viewAnswersBtn.setBackground(new Color(100, 150, 250));
        viewAnswersBtn.setForeground(Color.WHITE);
        viewAnswersBtn.setFocusPainted(false);
        viewAnswersBtn.setAlignmentX(Component.LEFT_ALIGNMENT);

        viewAnswersBtn.addActionListener(e -> showCorrectAnswers());

        resultPanel.add(resultLabel);
        resultPanel.add(Box.createVerticalStrut(25));
        resultPanel.add(viewAnswersBtn);

        mainPanel.add(resultPanel, "Result");
        cardLayout.show(mainPanel, "Result");
    }

    private void showCorrectAnswers() {
        JPanel ansPanel = new JPanel();
        ansPanel.setLayout(new BoxLayout(ansPanel, BoxLayout.Y_AXIS));
        ansPanel.setBackground(Color.WHITE);
        ansPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        JLabel title = new JLabel("Correct Answers:");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel q1 = new JLabel("1. What is the capital of India?");
        q1.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel a1 = new JLabel("Delhi");
        a1.setForeground(new Color(0, 153, 0));
        a1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel q2 = new JLabel("2. List the crops available in all seasons in India:");
        q2.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel a2 = new JLabel("Rice, Maize");
        a2.setForeground(new Color(0, 153, 0));
        a2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        ansPanel.add(title);
        ansPanel.add(Box.createVerticalStrut(20));
        ansPanel.add(q1);
        ansPanel.add(a1);
        ansPanel.add(Box.createVerticalStrut(15));
        ansPanel.add(q2);
        ansPanel.add(a2);

        mainPanel.add(ansPanel, "Answers");
        cardLayout.show(mainPanel, "Answers");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(question_and_answer::new);
    }
}
