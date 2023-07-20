module com.example.xaydungtinhnangdangnhap {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.xaydungtinhnangdangnhap to javafx.fxml;
    exports com.example.xaydungtinhnangdangnhap;
}