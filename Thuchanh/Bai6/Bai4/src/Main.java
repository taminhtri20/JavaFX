import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();

        String query = "UPDATE users Set password = ? WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);

            pstm.setString(1,"tri123");
            pstm.setInt(2,5);

            int row = pstm.executeUpdate();
            if (row != 0){
                System.out.println("Updated" + row);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        String query1 = "SELECT * FROM users";
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query1);
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                System.out.println(id + " - " + username + " - " + password + " - " + email);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}