import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();
        String query = "INSERT INTO products(id,name,price,detail,manufacturer,number,status)"
                + "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);

            pstm.setInt(1,11);
            pstm.setString(2,"x");
            pstm.setInt(3,12323);
            pstm.setString(4,"x");
            pstm.setString(5,"x");
            pstm.setInt(6,1);
            pstm.setString(7,"x");

            int row = pstm.executeUpdate();
            if (row != 0){
                System.out.println("Update" +row);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}