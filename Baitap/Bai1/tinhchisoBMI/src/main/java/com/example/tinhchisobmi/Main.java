package com.example.tinhchisobmi;

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
    private TextField kg;
    @FXML
    private TextField m;
    @FXML
    private void action(){
        double bmi;
        bmi = Integer.parseInt(kg.getText()) / (Double.parseDouble(m.getText()) * 2 );
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (bmi <18.5){
            alert.setContentText("gay`");
        } else if (bmi >= 18.5 && bmi <24.9) {
            alert.setContentText("binh thuong");
        } else if (bmi > 25 && bmi < 29.9) {
            alert.setContentText("tien` beo phi`");
        } else if (bmi > 30 && bmi < 34.9) {
            alert.setContentText("beo phi cap do 1");
        } else if (bmi > 35 && bmi < 39.9) {
            alert.setContentText("beo phi cap do 2");
        } else if (bmi > 40) {
            alert.setContentText("beo phi cap do 3");
        }
        alert.show();
    }
}
