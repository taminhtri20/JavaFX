import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8080);

        byte[] bytes ;
        DatagramPacket sendPacket;
        DatagramPacket receivePacket;

        while (true){
            bytes = new byte[65535];
            receivePacket = new DatagramPacket(bytes,bytes.length);

            datagramSocket.receive(receivePacket);

            String inp = new String(receivePacket.getData(),receivePacket.getOffset(), receivePacket.getLength());

            System.out.println("Phép tính nhận được: " + inp);

            if (inp.equals("bye")){
                System.out.println("Client gửi lệnh 'bye'.....ĐANG THOÁT");
                break;
            }
            int resuslt = 0;
            StringTokenizer st = new StringTokenizer(inp);

            int oprnd1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int oprnd2 = Integer.parseInt(st.nextToken());

            if (operation.equals("+")){
                resuslt = oprnd1 + oprnd2;
            } else if (operation.equals("-")) {
                resuslt = oprnd1 - oprnd2;
            } else if (operation.equals("*")) {
                resuslt = oprnd1 * oprnd2;
            } else {
                resuslt = oprnd1 / oprnd2;
            }

            System.out.println("Dang gui ket qua");
            String res = Integer.toString(resuslt);
            bytes = res.getBytes();

            int port = receivePacket.getPort();

            sendPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),port);
            datagramSocket.send(sendPacket);
        }
        datagramSocket.close();
    }
}
