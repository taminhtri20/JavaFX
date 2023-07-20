package com.example.ungdunghienthidanhdsachsinhvien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        VBox root = fxmlLoader.load();
        HelloController helloController = fxmlLoader.getController();

        helloController.getListView().getItems().addAll(
                new Student(1,"tri",20),
                new Student(2,"anh",20),
                new Student(3,"Ly",20)
        );
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Student list");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}