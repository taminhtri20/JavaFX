package com.example.ungdungtinhtuoi;

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
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private TextField year;

    @FXML
    private void caculatorage() {
        int now = 2023;
        int age;
        age = now - Integer.parseInt(year.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Tuoi cua ban la`: " + age);
        alert.show();
    }
}
