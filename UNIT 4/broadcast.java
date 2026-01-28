import java.io.*;
import java.net.*;
import java.util.Scanner;

public class broadcast{

    public static void main(String[] args) {
        int port = 8090; // same port always

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            System.out.println("Anyone on same Wi-Fi can open browser at http://<Your_PC_IP>:" + port);

            Scanner sc = new Scanner(System.in);

            while (true) { // keep server running
                System.out.print("Enter the message to broadcast: ");
                String message = sc.nextLine();

                System.out.println("Waiting for a client to connect...");

                Socket client = serverSocket.accept(); // wait for client
                System.out.println("Connection from: " + client.getInetAddress());

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Send HTTP response with the message
                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html; charset=UTF-8");
                out.println();
                out.println("<html><body>");
                out.println("<h2>" + escapeHtml(message) + "</h2>");
                out.println("</body></html>");

                out.close();
                client.close();

                System.out.println("✅ Message sent to client.\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escape HTML special characters
    private static String escapeHtml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#39;");
    }
}
