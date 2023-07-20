package com.example.ungdungmaytinhdongian;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public TextField sodautien;
    @FXML
    public RadioButton cong;
    public RadioButton tru;
    public RadioButton nhan;
    public RadioButton chia;
    public ToggleGroup operatorGroup;
    @FXML
    public TextField sothuhai;

    @FXML
    private void action() {
        int ketqua;
        int number1 = Integer.parseInt(sodautien.getText());
        int number2 = Integer.parseInt(sothuhai.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        RadioButton toggle = (RadioButton) operatorGroup.getSelectedToggle();
        if (toggle.equals(cong)){
            ketqua = number1 + number2;
            alert.setContentText("Ket qua: "+ketqua);
        } else if (toggle.equals(tru)) {
            ketqua = number1 - number2;
            alert.setContentText("Ket qua: "+ketqua);
        } else if (toggle.equals(nhan)) {
            ketqua = number1 * number2;
            alert.setContentText("Ket qua: "+ketqua);
        } else if (toggle.equals(chia)) {
            ketqua = number1 / number2;
            alert.setContentText("Ket qua: "+ketqua);
        }
        alert.show();
    }
}
