package com.example.ungdungthitracnghiem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerScene1 {
    public Stage stage;
    public Scene scene;
    public Parent root;
    validateEmail ve = new validateEmail();
    @FXML
    protected TextField name;
    @FXML
    protected TextField clasS;
    @FXML
    protected TextField mail;

    @FXML
    protected void next(ActionEvent actionEvent) throws IOException {
        if (!name.getText().isEmpty()
                && !clasS.getText().isEmpty()
                && !mail.getText().isEmpty()
                && ve.validate(mail.getText())){
            root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            stage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("Vui long dien day du thong tin");
//            alert.show();
        }
    }


    @FXML
    public RadioButton A;
    public RadioButton B;
    public RadioButton C;
    public RadioButton D;
    public RadioButton E;
    public ToggleGroup togglegroup1;
    public ToggleGroup togglegroup2;
    public ToggleGroup togglegroup3;
    public ToggleGroup togglegroup4;
    public ToggleGroup togglegroup5;

}