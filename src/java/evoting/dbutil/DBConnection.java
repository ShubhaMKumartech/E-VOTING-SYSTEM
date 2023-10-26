package evoting.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection conn=null;
    static{
        try{
           Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-8HA05OI:1521/XE", "evoting", "evoting");
            System.out.println("Connection opend successfully");
        }
        catch(ClassNotFoundException cnf){
            JOptionPane.showMessageDialog(null, "Cannot load the driver","ERROR",JOptionPane.ERROR_MESSAGE);
            cnf.printStackTrace();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problem in Db","ERROR",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            if(conn!=null)
                conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot Close the connection","ERROR",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}