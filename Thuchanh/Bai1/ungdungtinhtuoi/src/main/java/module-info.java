module com.example.ungdungtinhtuoi {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ungdungtinhtuoi to javafx.fxml;
    exports com.example.ungdungtinhtuoi;
}