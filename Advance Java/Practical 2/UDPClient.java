import java.io.*;
import java.net.*;

public class UDPClient {
    private static final int PACKET_SIZE = 1024;
    
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        DatagramPacket receivePacket, sendPacket;
        String fileName = "content.txt";
        int port = 4444;
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            clientSocket = new DatagramSocket();

            byte[] sendData = fileName.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[PACKET_SIZE];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            while (true) {
                clientSocket.receive(receivePacket);
                String line = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if (line.equals("EOF")) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}

