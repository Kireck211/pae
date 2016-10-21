package iteso.mx;


import iteso.mx.emails.SendEmail;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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


    public HashMap<Integer, String> getStates() {
        HashMap<Integer, String> states = new HashMap<Integer, String>();

        String queryStates ="SELECT [IDEstado],\n" +
                "\t[Nombre]\n" +
                "FROM [AUTOBUS].[dbo].[ESTADO]\n" +
                "WHERE IDPais=1\n";

        try {
            resultSet = statement.executeQuery(queryStates);
            while(resultSet.next()) {
                states.put(resultSet.getInt("IDEstado"), resultSet.getString("Nombre"));
            }
            return states;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return states;
    }

    public HashMap<Integer, String> getCities(int stateID) {
        HashMap<Integer, String> cities = new HashMap<Integer, String>();

        String queryCities = "SELECT *\n" +
                "  FROM [AUTOBUS].[dbo].[CIUDAD]\n" +
                "  WHERE IDEstado=" + stateID;

        try {
            resultSet = statement.executeQuery(queryCities);
            while(resultSet.next())
                cities.put(resultSet.getInt("IDCiudad"), resultSet.getString("Nombre"));
            return cities;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
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