package iteso.mx.UI;

import javax.swing.*;

/**
 * Created by Erick on 14/09/2016.
 */
public class BienvenidaPanel extends JPanel{
    private JLabel bienvenidaJLabel;
    private JButton inicioSesionJButton;

    public  BienvenidaPanel() {
        bienvenidaJLabel = new JLabel("Bienvenido");
        inicioSesionJButton = new JButton("Inicio Sesion");






        this.add(bienvenidaJLabel);
        this.add(inicioSesionJButton);
    }
}
