module com.example.sudungfilechooser {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.sudungfilechooser to javafx.fxml;
    exports com.example.sudungfilechooser;
}