package com.example.server;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    private DatagramSocket datagramSocket;
    private DatagramPacket datagramPacket;
    public Server(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }

    public void receiveMessageFromClient(VBox vboxMessage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!datagramSocket.isClosed()){
                    try {
                        byte[] bytes = new byte[1024];
                        datagramPacket = new DatagramPacket(bytes, bytes.length);
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

    public void sendMessageToClient(String messageToSend) {
        try {
            byte[] data = messageToSend.getBytes();
            datagramPacket =
                    new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"),8888);
            datagramSocket.send(datagramPacket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
