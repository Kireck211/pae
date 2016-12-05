package iteso.mx.Validators;

import iteso.mx.Models.Employee;

import javax.swing.*;

/**
 * Created by Erick on 04/12/2016.
 */
public class EmployeeValidator {

    public boolean isValidEmployee(Employee employee) {
        if(!isValidName(employee.name)) {
            JOptionPane.showMessageDialog(null, "El nombre del empleado debe tener 3 carácteres como mínimo", "Error en el nombre", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!isValidUser(employee.user)) {
            JOptionPane.showMessageDialog(null, "El usuario del empleado debe tener 3 carácteres como mínimo", "Error en el usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!isValidPassword(employee.password)) {
            JOptionPane.showMessageDialog(null, "La contraseña del empleado debe tener 3 carácteres como mínimo", "Error en el contraseña", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!isValidP(employee.apP)) {
            JOptionPane.showMessageDialog(null, "El apellido paterno del empleado debe tener 3 carácteres como mínimo", "Error en el apellido paterno", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!isValidP(employee.apM)) {
            JOptionPane.showMessageDialog(null, "El apellido materno del empleado debe tener 3 carácteres como mínimo", "Error en el apellido materno", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean isValidUser(String user) {
        if (user.length() > 3)
            return true;
        return false;
    }

    public boolean isValidPassword(String password) {
        if (password.length() > 3)
            return true;
        return false;
    }

    public boolean isValidName(String name) {
        if (name.length() > 3)
            return true;
        return false;
    }

    public boolean isValidP(String ap) {
        if (ap.length() > 3)
            return true;
        return false;
    }
}
