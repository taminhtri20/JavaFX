import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    private static final int PIECES_OF_FILE_SIZE = 1024*32;
    private DatagramSocket datagramSocket;
    private int port = 6677;

    public void openServer() throws IOException {
        try {
            datagramSocket = new DatagramSocket(port);
            System.out.println("Server is opened on port " + port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void receiveFile() throws IOException, ClassNotFoundException {
        byte[] receiveData = new byte[PIECES_OF_FILE_SIZE];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        datagramSocket.receive(receivePacket);
        InetAddress inetAddress = receivePacket.getAddress();
        ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        fileInfo fileInfo = (fileInfo) ois.readObject();

        if (fileInfo != null){
            System.out.println("File name: " + fileInfo.getFileName());
            System.out.println("File size: " + fileInfo.getFileSize());
            System.out.println("Pieces of file: " + fileInfo.getPiecesOfFile());
            System.out.println("Last bytes length: "+ fileInfo.getLastByteLength());
        }
        System.out.println("Receiving file...");
        File fileReceive = new File(fileInfo.getDestinationDirectory() + fileInfo.getFileName());
        BufferedOutputStream bos  = new BufferedOutputStream(new FileOutputStream(fileReceive));

        for (int i=0; i<(fileInfo.getPiecesOfFile()-1); i++){
            receivePacket = new DatagramPacket(receiveData, receiveData.length,inetAddress,port);
            datagramSocket.receive(receivePacket);
            bos.write(receiveData,0,PIECES_OF_FILE_SIZE);
        }
        receivePacket = new DatagramPacket(receiveData, receiveData.length,inetAddress,port);
        datagramSocket.receive(receivePacket);
        bos.write(receiveData,0,fileInfo.getLastByteLength());
        bos.flush();
        System.out.println("Done!");
        bos.close();
    }
}
