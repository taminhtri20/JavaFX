module com.example.ungdungchuydoitiente {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ungdungchuydoitiente to javafx.fxml;
    exports com.example.ungdungchuydoitiente;
}