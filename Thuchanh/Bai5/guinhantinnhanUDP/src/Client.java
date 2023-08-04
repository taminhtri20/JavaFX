import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;

        DatagramSocket datagramSocket = new DatagramSocket();

        String message = "Hello, server!";
        byte[] bytes = message.getBytes();

        InetAddress serverAddress = InetAddress.getByName(serverIP);
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,serverAddress,serverPort);

        datagramSocket.send(datagramPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);

        datagramSocket.receive(receivePacket);

        String receiveMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
        System.out.println("Receive from server: "+receiveMessage);

        datagramSocket.close();
    }
}
