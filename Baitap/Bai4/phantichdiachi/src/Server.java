import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static validateIP validateIP;
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;

        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running and waiting for connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        byte[] buffer = new byte[1024];
        int bytesRead = dataInputStream.read(buffer);
        String message = new String(buffer, 0, bytesRead);
        validateIP validateIP1 = new validateIP();
        boolean isValid = validateIP1.validate(message);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        if (isValid){
            dataOutputStream.write(message.getBytes());
            System.out.println("asd");
        }else {
            dataOutputStream.write("Khong ton tai!".getBytes());
        }

        socket.close();
        serverSocket.close();
    }
}
