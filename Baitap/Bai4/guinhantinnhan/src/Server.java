import javax.annotation.processing.Messager;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;

        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Waiting....");

        Socket socket = serverSocket.accept();
        System.out.println("Accepted");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message;

        while ((message = bufferedReader.readLine()) != null){
            if (message.equals("exit")){
                break;
            }
            System.out.println("Client: "+message);
        }

        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
