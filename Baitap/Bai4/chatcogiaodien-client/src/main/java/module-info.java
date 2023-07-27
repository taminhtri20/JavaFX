module com.example.chatcogiaodienclient {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.chatcogiaodienclient to javafx.fxml;
    exports com.example.chatcogiaodienclient;
}