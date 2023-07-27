import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;

        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running and waiting for connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        int sum = dataInputStream.read() + dataInputStream.read();

        dataOutputStream.write(sum);

        socket.close();
        serverSocket.close();
    }
}
