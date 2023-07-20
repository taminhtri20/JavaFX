module com.example.ungdungmaytinhdongian {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ungdungmaytinhdongian to javafx.fxml;
    exports com.example.ungdungmaytinhdongian;
}