package iteso.mx.Models;

import iteso.mx.Model;

import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by Erick on 03/12/2016.
 */
public class Client extends Model{
    public int IDCliente;
    public String Nombre;
    public Date FechaNacimiento;
    public String Genero;
    public String RFC;
    private String getClientQuery = "Execute Datos_Cliente ";
    private String createClientQuery = "INSERT INTO EMPLEADO\n" +
                                        "VALUES(";

    public Client() {
    }

    public Client(String Nombre, int day, int month, int year, String Genero, String RFC) {
        this.Nombre = Nombre;
        this.FechaNacimiento = new Date(year, month, day);
        this.Genero = Genero;
        this.RFC = RFC;
    }

    public void createClient(String user, String password, String name, String apP, String apM, String gender) {
        createClientQuery += ("'" + user + "',");
        createClientQuery += ("'" + password + "',");
        createClientQuery += ("'" + name + "',");
        createClientQuery += ("'" + apP + "',");
        createClientQuery += ("'" + apM + "',");
        createClientQuery += ("'" + gender + "')");

        try {
            resultSet = statement.executeQuery(createClientQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setClient (String nombre) {
        getClientQuery += ("'" + nombre + "'");
        try {
            resultSet = statement.executeQuery(getClientQuery);
            while (resultSet.next()) {
                this.IDCliente = resultSet.getInt("IDCliente");
                this.Nombre = resultSet.getString("Nombre");
                this.FechaNacimiento =  resultSet.getDate("FechaNacimiento");
                this.Genero = resultSet.getString("Genero");
                this.RFC = resultSet.getString("RFC");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
