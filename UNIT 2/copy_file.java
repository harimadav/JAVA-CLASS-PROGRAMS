package file;
import java.io.*;

public class copy_file {
    public static void main(String[] args) {
        try {
            // Create reader for input file
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);

            // Create writer for output file
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine(); // to keep same line breaks
            }

            // Close resources
            br.close();
            bw.close();

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

