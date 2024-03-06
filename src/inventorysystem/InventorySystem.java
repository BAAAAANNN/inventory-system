package inventorysystem;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class InventorySystem {
    private static String address = "jdbc:mysql://localhost:3306/inventorysystem";
    private static String userName = "root";
    private static String passWord = "";

    public static void main(String[] args) {
        InventorySystem callMe = new InventorySystem();
        new InventorySystem().Load();
    }
    
//    test for gh
    private void Load(){
        try {
            Connection conn = getConnection();
            System.out.println("Credentials working");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection error:");
            e.printStackTrace();
        }
        
        Home LoginFrame = new Home();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);//to center
        
        

    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(address, userName, passWord);
    }
    
    
//  Move to diff location
//    int loginCheck(String userEmail, String passWord) {
//        int rowsAffected = 0;
//        try {
//            Connection conn = DriverManager.getConnection(address, userName, passWord);
//            String sqlQuery = "SELECT COUNT(*) FROM tbl_users "
//                    + "WHERE fld_username = ? AND fld_password = ?;";
//            conn.setAutoCommit(false);
//            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
//            stmt.setString(1, userEmail);
//            stmt.setString(2, passWord);
//            
//            ResultSet resultSet = stmt.executeQuery();
//        
//            if (resultSet.next()) {
//            rowsAffected = resultSet.getInt(1);
//            }
//     
//            conn.commit();
//        
//            resultSet.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("SQL error: " + e.getMessage());
//        } catch (Exception e){
//            System.out.println("Error: " + e.toString());
//        }
//        
//        return rowsAffected; 
//    }
        
}
