module com.example.ungdungthitracnghiem {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ungdungthitracnghiem to javafx.fxml;
    exports com.example.ungdungthitracnghiem;
}