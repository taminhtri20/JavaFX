module com.example.ungdunghienthidanhdsachsinhvien {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ungdunghienthidanhdsachsinhvien to javafx.fxml;
    exports com.example.ungdunghienthidanhdsachsinhvien;
}