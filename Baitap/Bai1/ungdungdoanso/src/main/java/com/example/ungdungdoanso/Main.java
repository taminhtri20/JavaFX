package com.example.ungdungdoanso;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

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
    private TextField number;
    @FXML
    private void action(){
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(100) ;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (Integer.parseInt(number.getText()) == randomNumber){
            alert.setContentText("Nhap dung");
        }else {
            alert.setContentText("Nhap sai,so can chon la: "+randomNumber);
        }
        alert.show();
    }
}
