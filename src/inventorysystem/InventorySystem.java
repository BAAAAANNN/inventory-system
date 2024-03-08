package inventorysystem;


import java.sql.*;
import javax.swing.JFrame;

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
        
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);//to center
        
        

    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(address, userName, passWord);
    }
    
        
}
