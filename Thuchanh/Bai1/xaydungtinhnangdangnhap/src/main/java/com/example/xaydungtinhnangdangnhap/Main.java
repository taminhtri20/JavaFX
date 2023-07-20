package com.example.xaydungtinhnangdangnhap;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));

        Scene scene = new Scene(fxmlLoader.load(),600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private void action(){
        if (user.getText().equals("admin") || pass.getText().equals("pass")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("dang nhap thanh cong");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("dang nhap that bai");
            alert.show();
        }
    }
}
