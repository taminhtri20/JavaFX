import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();

        String query = "DELETE FROM products WHERE id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);
            pstm.setInt(1,4);
            int row = pstm.executeUpdate();
            if (row != 0){
                System.out.println("Update!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String query1 = "SELECT * FROM products";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query1);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                String status = rs.getString("status");
                System.out.println("id:"+id+" -name:"+name+" -price:"+price+" -detail:"+detail+" -manufacturer:"+manufacturer+" -number:"+number+" -status:"+status);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}