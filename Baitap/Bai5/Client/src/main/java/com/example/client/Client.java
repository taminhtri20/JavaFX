package com.example.client;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;
    private int serverPort = 8080;
    private String serverIP = "127.0.0.1";
    public Client(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }

    public void receiveMessageFromServer(VBox vboxMessage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!datagramSocket.isClosed()){
                    try {
                        byte[] data = new byte[1024];
                        datagramPacket = new DatagramPacket(data,data.length);
                        datagramSocket.receive(datagramPacket);
                        String message = new String(datagramPacket.getData(),0, datagramPacket.getLength());
                        HelloController.addLabel(message,vboxMessage);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void sendMessageToServer(String messageToSend) {
        try {
            byte[] data = messageToSend.getBytes();
            InetAddress inetAddress = InetAddress.getByName(serverIP);
            datagramPacket =
                    new DatagramPacket(data,data.length,inetAddress,serverPort);
            datagramSocket.send(datagramPacket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
