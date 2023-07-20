module com.example.ungdungdoanso {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ungdungdoanso to javafx.fxml;
    exports com.example.ungdungdoanso;
}