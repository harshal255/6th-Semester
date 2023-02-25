import java.io.*;
import java.net.*;

public class UDPServer {
    private static final int PACKET_SIZE = 1024;
    
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        DatagramPacket receivePacket, sendPacket;
        int port = 4444;
        try {
            serverSocket = new DatagramSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                byte[] receiveData = new byte[PACKET_SIZE];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                String fileName = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received file name: " + fileName);
                
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                byte[] sendData;
                while ((line = br.readLine()) != null) {
                    sendData = line.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                    serverSocket.send(sendPacket);
                }
                sendData = "EOF".getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}

