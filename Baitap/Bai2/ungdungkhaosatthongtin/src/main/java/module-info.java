module com.example.ungdungkhaosatthongtin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ungdungkhaosatthongtin to javafx.fxml;
    exports com.example.ungdungkhaosatthongtin;
}