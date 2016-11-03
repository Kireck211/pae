package iteso.mx.UI.SalesTabs;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aldo on 02/11/2016.
 */
public class Header extends JPanel {
    private JLabel nombreEmpleado;
    private JLabel IDEmpleado;
    private JLabel hora;


    public Header(){
        super(new GridLayout(1,0));
        setBackground(new Color(82, 82, 84));
        nombreEmpleado = new JLabel("Nombre Empleado");
        IDEmpleado = new JLabel("ID Empleado");
        hora = new JLabel("Hora");
        nombreEmpleado.setForeground(new Color(251, 251, 251));
        IDEmpleado.setForeground(new Color(251, 251, 251));
        hora.setForeground(new Color(251, 251, 251));
        add(nombreEmpleado);
        add(IDEmpleado);
        add(hora);
    }
}
