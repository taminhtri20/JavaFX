module com.example.tinhchisobmi {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.tinhchisobmi to javafx.fxml;
    exports com.example.tinhchisobmi;
}