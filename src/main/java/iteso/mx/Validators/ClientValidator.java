package iteso.mx.Validators;

import iteso.mx.Models.Client;

import javax.swing.*;

/**
 * Created by Erick on 04/12/2016.
 */
public class ClientValidator {

    public boolean isValidClient(Client client) {
        if (!isValidName(client.Nombre)) {
            JOptionPane.showMessageDialog(null, "El nombre debe tener una longitud mínima de 3 carácteres", "Error en el nombre", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!isValidRFC(client.RFC)) {
            JOptionPane.showMessageDialog(null, "El RFC debe de tener 12 o 13 carácteres", "Error en el RFC", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean isValidName(String name) {
        if (name.length() > 3)
            return true;
        return false;
    }

    public boolean isValidRFC(String rfc) {
        if (rfc.length() > 11 && rfc.length() < 14)
            return true;
        return false;
    }
}
