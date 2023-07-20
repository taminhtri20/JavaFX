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

public class ControllerScene2 {
    String dapan1;
    String dapan2;
    String dapan3;
    String dapan4;
    String dapan5;
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

    @FXML
    public int point;
    @FXML
    protected void Exam() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        RadioButton toggle1 = (RadioButton) togglegroup1.getSelectedToggle();
        RadioButton toggle2 = (RadioButton) togglegroup2.getSelectedToggle();
        RadioButton toggle3 = (RadioButton) togglegroup3.getSelectedToggle();
        RadioButton toggle4 = (RadioButton) togglegroup4.getSelectedToggle();
        RadioButton toggle5 = (RadioButton) togglegroup5.getSelectedToggle();
        if (toggle1.equals(A)){
            point = point +2;
        }  if (toggle2.equals(B)) {
            point = point +2;
        }  if (toggle3.equals(C)) {
            point = point +2;
        }  if (toggle4.equals(D)) {
            point = point +2;
        }  if (toggle5.equals(E)) {
            point = point +2;
        }
        dapan1 = A.getText();
        dapan2 = B.getText();
        dapan3 = C.getText();
        dapan4 = D.getText();
        dapan5 = E.getText();
        alert.setContentText("Dap an dung cau 1: "
                + dapan1
                +"\n"
                +"Dap an dung cau 2: "
                + dapan2
                + "\n"
                +"Dap an dung cau 3: "
                + dapan3
                + "\n"
                +"Dap an dung cau 4: "
                + dapan4
                + "\n"
                +"Dap an dung cau 5: "
                + dapan5
                + "\n"
                + "Tong diem cua ban la: " +point);
        alert.show();
    }
}
