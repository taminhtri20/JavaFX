import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String hostName = "localhost:3306";
    private String dbName = "demo_jdbc";
    private String userName = "root";
    private String password = "password";
    private String connectionURL = "jdbc:mysql://" + hostName + "/" +dbName;
    public Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL,userName,password);
            System.out.println("Conected");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
