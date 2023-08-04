import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getLocalHost();

        byte[] bytes;
        while (true){
            System.out.print("Nhập phép tính theo định dạng:");
            System.out.println("'số_hạng_1 toán_tử số_hạng_2'");
            String inp  = scanner.nextLine();

            bytes = inp.getBytes();

            DatagramPacket sendMessage = new DatagramPacket(bytes, bytes.length,inetAddress,8080);

            datagramSocket.send(sendMessage);

            if (inp.equals("bye")){
                break;
            }

            bytes = new byte[65535];

            DatagramPacket receiveMessage = new DatagramPacket(bytes, bytes.length);

            datagramSocket.receive(receiveMessage);

            String result = new String(receiveMessage.getData(),receiveMessage.getOffset(),receiveMessage.getLength());
            System.out.println("Result: "+result);
        }
        datagramSocket.close();
    }
}
