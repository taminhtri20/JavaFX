package com.example.chatcogiaodien;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;

    public Server(ServerSocket serverSocket){
        try {
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error...");
            closeEverything(socket,br,bw);
        }
    }
    public void sendMessageToClient(String messageToClient){
        try {
            bw.write(messageToClient);
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
            closeEverything(socket,br,bw);
        }
    }
    public void receiveMessageFromClient(VBox vBox){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String messageFromClient = br.readLine();
                        HelloController.addLabel(messageFromClient,vBox);
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
