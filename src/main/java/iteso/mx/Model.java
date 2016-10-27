package iteso.mx;


import iteso.mx.emails.SendEmail;

import java.sql.*;
import java.util.*;


public class Model {

    private static final String DEFAULT_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DEFAULT_URL = "jdbc:sqlserver://localhost:1433;databaseName=AUTOBUS";
    private static final String DEFAULT_USERNAME = "test";
    private static final String DEFAULT_PASSWORD = "123456";
    public SendEmail sendEmail;
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
    public int idEmployee;

    public Model() {
        sendEmail = new SendEmail();
        connection = null;
        statement = null;
        resultSet = null;
        connect();
        this.idEmployee = -1;
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

    public void registerSell(String date, int numberTickets, int idRoute, int idEmployee, int idClient, String comment) {
        String executeProcedure = "execute SP_Realizar_Venta '" + date +
                "'," + numberTickets +
                "," + idRoute +
                "," + idEmployee +
                "," + idClient +
                ",'" + comment +"'";
        try {
            statement.executeQuery(executeProcedure);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRouteID(String srcCity, String destCity) {
        String executeProcedure = "execute SP_Ruta_Viaje '" + srcCity + "', '"+ destCity + "'";
        try {
            resultSet = statement.executeQuery(executeProcedure);
            if(!resultSet.wasNull()) {
                while(resultSet.next())
                    return resultSet.getInt(1);
            }
            else
                return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void setIDEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIDEmployeeDB(String userName) {
        String query = "SELECT [IDEmpleado]\n" +
                "  FROM [AUTOBUS].[dbo].[EMPLEADO]\n" +
                "  WHERE Usuario='" + userName + "'";
        try {
            resultSet = statement.executeQuery(query);
            if(!resultSet.wasNull()) {
                while(resultSet.next())
                    return resultSet.getInt("IDEmpleado");
            }
            else
                return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
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

    public Vector<Vector<Object>> getAllSells(){
        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
        String sellsProcedure = "execute SP_Mostrar_Total_Ventas";
        Vector<Object> aux = new Vector<Object>();

        try{

            resultSet = statement.executeQuery(sellsProcedure);
            while(resultSet.next()){
                String s1 = resultSet.getString(1);
                String s2 = resultSet.getString(2);
                String s3 = resultSet.getString(3);
                String s4 = resultSet.getString(4);
                String s5 = resultSet.getString(5);
                String s6 = resultSet.getString(6);
                String s7 = resultSet.getString(7);
                String s8 = resultSet.getString(8);
                String s9 = resultSet.getString(9);
                String s10= resultSet.getString(10);
                aux = (new Vector<Object>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10)));
                rows.add(aux);
            }
        }catch (Exception e){

        }


        return rows;

    }
}