import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;
        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket(serverIP,serverPort);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("Nhap dia chi IP: ");
        String message = scanner.next();
        dataOutputStream.write(message.getBytes());

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        byte[] buffer = new byte[1024];
        int bytesRead = dataInputStream.read(buffer);
        String message1 = new String(buffer, 0, bytesRead);
        System.out.println(message1);

        socket.close();
    }
}
