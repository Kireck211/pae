package iteso.mx.DataBaseConnection;

import java.sql.*;
import javax.swing.JOptionPane;

//Para SQL Server
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import baseDeDatos.tools.Commons;

public class MyConnection {

    public static Connection conn;

    public static Connection getInstance() throws Exception{
        if (conn ==null){
            Class.forName(Commons.DRIVER).newInstance();
            conn = DriverManager.getConnection(Commons.URL + Commons.DBNAME, Commons.USER, Commons.PASSWORD);
        }
        return conn;
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }
}
