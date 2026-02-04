import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class black_and_white_concvertor extends JFrame implements ActionListener {

    private JLabel imageLabel;
    private BufferedImage originalImage, grayImage;
    private JButton uploadButton, bwButton, saveButton;
    private boolean isConverted = false; // ✅ flag to track conversion status

    public black_and_white_concvertor() {
        setTitle("Image B/W Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // ===== Left Panel (Image Display) =====
        imageLabel = new JLabel("No Image Uploaded", SwingConstants.CENTER);
        imageLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(imageLabel, BorderLayout.CENTER);

        // ===== Right Panel (Buttons) =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(80, 30, 80, 30));

        uploadButton = new JButton("Upload");
        bwButton = new JButton("B/W");
        saveButton = new JButton("Save");

        JButton[] buttons = { uploadButton, bwButton, saveButton };
        for (JButton btn : buttons) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 22));
            btn.setFocusPainted(false);
            btn.setBackground(new Color(240, 240, 240));
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == uploadButton) {
            handleUpload();
        } else if (source == bwButton) {
            handleBWConversion();
        } else if (source == saveButton) {
            handleSave();
        }
    }

    // ===== Handle Upload =====
    private void handleUpload() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an Image");
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                originalImage = ImageIO.read(file);
                grayImage = null;
                isConverted = false; // ✅ Reset conversion status on new upload

                Image scaled = originalImage.getScaledInstance(
                        imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaled));
                imageLabel.setText("");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading image!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ===== Handle B/W Conversion =====
    private void handleBWConversion() {
        if (originalImage == null) {
            JOptionPane.showMessageDialog(this, "Please upload an image first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (isConverted) { // ✅ Already converted check
            JOptionPane.showMessageDialog(this, "This image is already converted to Black & White!", 
                    "Notice", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        Graphics g = grayImage.getGraphics();
        g.drawImage(originalImage, 0, 0, null);
        g.dispose();

        Image scaled = grayImage.getScaledInstance(
                imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaled));
        imageLabel.setText("");

        isConverted = true; // ✅ Mark as converted
    }

    // ===== Handle Save =====
    private void handleSave() {
        if (grayImage == null && originalImage == null) {
            JOptionPane.showMessageDialog(this, "No image to save!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        BufferedImage imageToSave = (grayImage != null) ? grayImage : originalImage;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Image");
        fileChooser.setSelectedFile(new File("output.png"));

        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                ImageIO.write(imageToSave, "png", file);
                JOptionPane.showMessageDialog(this, "Image saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving image!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(black_and_white_concvertor::new);
    }
}
