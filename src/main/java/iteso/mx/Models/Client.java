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
