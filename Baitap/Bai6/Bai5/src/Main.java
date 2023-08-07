import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connection();

//        String query = "SELECT * FROM products";
//        String query = "SELECT * FROM products WHERE id = 3";
//        String query = "SELECT * FROM products WHERE id = 3 or id = 5";
//        String query = "SELECT  * FROM  products WHERE status = '0' ";
        String query = "SELECT * FROM products WHERE status = '1' and number = 9";

        Statement stm = null;
        try {
            stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
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