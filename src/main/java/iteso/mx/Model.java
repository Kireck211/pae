package iteso.mx;


import iteso.mx.emails.SendEmail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by Erick on 23/09/2016.
 */
public class Model {

    private static final String DEFAULT_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DEFAULT_URL = "jdbc:sqlserver://localhost:1433;databaseName=AUTOBUS";
    private static final String DEFAULT_USERNAME = "test";
    private static final String DEFAULT_PASSWORD = "123456";
    public SendEmail sendEmail;
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public Model() {
        sendEmail = new SendEmail();
        connection = null;
        statement = null;
        resultSet = null;
        connect();
    }

    public void connect() {
        try {
            Class.forName(DEFAULT_DRIVER_CLASS);
            connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPassword(String username) {

        String queryPassword = "SELECT Contraseña FROM EMPLEADO\n" +
                "WHERE Usuario = '" + username + "'";

        try {
            resultSet = statement.executeQuery(queryPassword);
            if (resultSet.next()) {
                return resultSet.getString(1);
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "No connection";
    }

    public void closeConnection() {
        if (resultSet != null) try {
            resultSet.close();
            System.out.println("ResultSet Closed");
        } catch(Exception e) {
            System.out.println("Cant' close");
        }
        if (statement != null) try {
            statement.close();
            System.out.println("Statement Closed");
        } catch(Exception e) {
            System.out.println("Cant' close");
        }
        if (connection != null) try {
            connection.close();
            System.out.println("Connection Closed");
        } catch (Exception e) { e.printStackTrace();}
    }
}
