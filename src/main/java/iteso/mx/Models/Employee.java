package iteso.mx.Models;

import iteso.mx.Model;

/**
 * Created by Erick on 04/12/2016.
 */
public class Employee extends Model{
    public String user;
    public String password;
    public String name;
    public String apP;
    public String apM;
    public String gender;

    public Employee() {
    }

    public Employee(String user, String password, String name, String apP, String apM, String gender) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.apP = apP;
        this.apM = apM;
        this.gender = gender;
    }
}
