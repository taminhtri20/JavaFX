import java.io.OutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int serverPort = 8888;

        try {
            Socket socket = new Socket(serverIP,serverPort);

            OutputStream os = socket.getOutputStream();
            String message = "Hello, server. I'm tri";
            os.write(message.getBytes());

            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
