module com.example.chatcogiaodien {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.chatcogiaodien to javafx.fxml;
    exports com.example.chatcogiaodien;
}