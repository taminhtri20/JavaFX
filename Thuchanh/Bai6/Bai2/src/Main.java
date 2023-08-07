import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();

        String query = "SELECT * From users";

        Statement stm = null;
        try {
            stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                System.out.println(id + "-" + username + "-" +password + "-" + email);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}