import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;

        Socket socket = new Socket(serverIP,serverPort);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message;
        System.out.println("Nhap tin: ");

        while ((message = br.readLine()) != null){
            System.out.println("Nhap tin: ");
            printWriter.println(message);

            if (message.equals("exit")){
                break;
            }
        }

        br.close();
        printWriter.close();
        socket.close();
    }
}
