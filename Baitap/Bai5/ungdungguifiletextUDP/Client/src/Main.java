public class Main {
    public static void main(String[] args) {
        String srcPath = "/home/taminhtri/Client/test";
        String destinationDir = "/home/taminhtri/Server";
        Client client = new Client();
        client.connectServer();
        client.sendFile(srcPath,destinationDir);
    }
}