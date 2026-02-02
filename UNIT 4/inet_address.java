import java.net.*;
import java.util.*;

public class inet_address{
    public static void main(String[] args) {
        try {
            // Get local host InetAddress
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("IP Address : " + localHost.getHostAddress());
            System.out.println("Host Name  : " + localHost.getHostName());

            // Get NetworkInterface for the InetAddress
            NetworkInterface network = NetworkInterface.getByInetAddress(localHost);

            if (network != null) {
                byte[] mac = network.getHardwareAddress();

                if (mac != null) {
                    // Convert MAC bytes to hex format
                    StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%02X%s",
                                mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + macAddress.toString());
                } else {
                    System.out.println("MAC Address not available!");
                }
            } else {
                System.out.println("Network Interface not found!");
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to find host.");
        } catch (SocketException e) {
            System.out.println("Error: Unable to get MAC address.");
        }
    }
}
