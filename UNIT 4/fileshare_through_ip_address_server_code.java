import java.io.*;
import java.net.*;

public class fileshare_through_ip_address_server_code {
    public static void main(String[] args) {
        int port = 5000; // Port number for connection

        // ✅ Use full path (escape backslashes)
        String filePath = "C:\\Users\\Lenovo\\Downloads\\SURPLUS FOOD MANAGEMENT.pdf";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("📡 Server started. Waiting for friend to connect...");

            Socket socket = serverSocket.accept();
            System.out.println("✅ Friend connected: " + socket.getInetAddress());

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("❌ File not found: " + filePath);
                socket.close();
                return;
            }

            // Send file metadata first (name + size)
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(file.getName());   // file name
            dos.writeLong(file.length());   // file size

            // Send file content
            try (FileInputStream fis = new FileInputStream(file);
                 BufferedInputStream bis = new BufferedInputStream(fis)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    dos.write(buffer, 0, bytesRead);
                }
                dos.flush();
                System.out.println("✅ File sent successfully: " + file.getName());
            }

            socket.close();
        } catch (IOException e) {
            System.err.println("⚠️ Error while sending file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
