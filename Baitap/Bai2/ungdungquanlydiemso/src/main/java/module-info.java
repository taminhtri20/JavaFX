module com.example.ungdungquanlydiemso {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ungdungquanlydiemso to javafx.fxml;
    exports com.example.ungdungquanlydiemso;
}