import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();

        String query = "INSERT INTO users(id, username, password, email)"
                     + "VALUES(?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);
            pstm.setInt(1,5);
            pstm.setString(2,"Tri");
            pstm.setString(3,"1234");
            pstm.setString(4,"tri@gmail.com");

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