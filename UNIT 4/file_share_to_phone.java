import java.io.*;
import java.net.*;

public class file_share_to_phone {
    public static void main(String[] args) {
        int port = 8000; // browser will use http://PC_IP:8000
        String filePath = "C:\\Users\\Lenovo\\Downloads\\SURPLUS FOOD MANAGEMENT.pdf";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("✅ Server started on port " + port);
            System.out.println("Your friend can access the file via browser at http://<Your_PC_IP>:" + port);

            while (true) { // keep server running
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream();

                // Read HTTP request (first line only)
                String line = in.readLine();
                System.out.println("Request: " + line);

                // Prepare file to send
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("❌ File not found!");
                    clientSocket.close();
                    continue;
                }

                byte[] fileData = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                bis.read(fileData, 0, fileData.length);
                bis.close();

                // Send HTTP response headers
                String header = "HTTP/1.0 200 OK\r\n" +
                                "Content-Type: application/pdf\r\n" +
                                "Content-Length: " + fileData.length + "\r\n" +
                                "Content-Disposition: attachment; filename=\"" + file.getName() + "\"\r\n" +
                                "\r\n";
                out.write(header.getBytes());

                // Send file data
                out.write(fileData, 0, fileData.length);
                out.flush();

                clientSocket.close();
                System.out.println("✅ File sent successfully to " + clientSocket.getInetAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


