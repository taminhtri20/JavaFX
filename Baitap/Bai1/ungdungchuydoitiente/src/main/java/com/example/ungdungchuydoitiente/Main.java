package com.example.ungdungchuydoitiente;

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
    private TextField usd;
    @FXML
    private void action(){
        int vnd;
        vnd = 23000 * Integer.parseInt(usd.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("So tien nhan dc la: "+vnd +"VND");
        alert.show();
    }
}
