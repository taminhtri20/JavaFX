package com.example.ungdungkhaosatthongtin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private ToggleGroup gender;

    @FXML
    protected void action() throws IOException {
        String information;
        RadioButton toggle = (RadioButton) gender.getSelectedToggle();

        information = "Name: " + name.getText() +
                      ", Age: " + age.getText() +
                      ", Gender: "+ toggle.getText();
        FileWriter fw = new FileWriter("data.txt");
        fw.write(information);
        fw.close();
    }
}