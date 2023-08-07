import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();

//        String query =
//                "UPDATE products Set detail = ? WHERE id = ?";
//        String query = "UPDATE products SET manufacturer = ? , price = ? WHERE id = ?";
        String query = "UPDATE  products SET number = ? , status = ? where id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);

//            pstm.setString(1,"dữ liệu mới");
//            pstm.setInt(2,4);

//            pstm.setString(1,"apple");
//            pstm.setInt(2,12000000);
//            pstm.setInt(3,2);
//
            pstm.setInt(1,20);
            pstm.setString(2,"0");
            pstm.setInt(3,6);

            int row = pstm.executeUpdate();
            if (row != 0){
                System.out.println("Updated "+ row);
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