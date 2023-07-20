package com.example.sudungfilechooser;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class controller {
    @FXML
    protected ImageView imageView;
    @FXML
    protected AnchorPane anchorPane;

    @FXML
    private void chooseImage(){
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a image");
        FileChooser.ExtensionFilter fe =
                new FileChooser.ExtensionFilter("Image file", "*jpeg", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(fe);
        File file = fileChooser.showOpenDialog(stage);

        if (file != null){
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }
}
