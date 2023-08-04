import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;

        DatagramSocket datagramSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running and waiting for client...");

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        datagramSocket.receive(receivePacket);

        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        String message = new String(receivePacket.getData(),0,receivePacket.getLength());
        System.out.println("Received from client: "+message);

        String sendMessage = "Hello, client!";
        byte[] bytes = sendMessage.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length,clientAddress,clientPort);
        datagramSocket.send(sendPacket);

        datagramSocket.close();
    }
}
