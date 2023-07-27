package com.example.chatcogiaodienclient;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;

    public Client(Socket socket){
        try {
            this.socket = socket;
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (IOException e){
            e.printStackTrace();
            closeEverything(socket,br,bw);
        }
    }
    public void sendMessageToServer(String messageToServer){
        try {
            bw.write(messageToServer);
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
            closeEverything(socket,br,bw);
        }
    }

    public void receiveMessageFromServer(VBox vBox){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String messageFromServer = br.readLine();
                        HelloController.addLabel(messageFromServer,vBox);
                    }catch (IOException e){
                        e.printStackTrace();
                        closeEverything(socket,br,bw);
                        break;
                    }
                }
            }
        }).start();
    }
    public void closeEverything(Socket socket,BufferedReader br,BufferedWriter bw){
        try {
            if (br != null){
                br.close();
            }
            if (bw  != null){
                bw.close();
            }
            if (socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
