import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;
        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket(serverIP, serverPort);

        OutputStream os = socket.getOutputStream();
        int message1;
        int message2;
        System.out.println("Nhap so nguyen: ");
        message1 = scanner.nextInt();

        System.out.println("Nhap so nguyen: ");
        message2 = scanner.nextInt();

        os.write(message1);
        os.write(message2);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println("Tong hai so la: " +dataInputStream.read());
        socket.close();
    }
}
