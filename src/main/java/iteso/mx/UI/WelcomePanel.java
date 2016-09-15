package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;


public class WelcomePanel extends JPanel{

    private JLabel bienvenidaJLabel;
    private JButton inicioSesionJButton;

    public WelcomePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        bienvenidaJLabel = new JLabel("Bienvenido");
        gb.weightx = .5;
        gb.gridx = 1;
        gb.gridy = 1;
        add(bienvenidaJLabel, gb);

        inicioSesionJButton = new JButton("Inicio Sesion");
        gb.weightx = .5;
        gb.gridx = 1;
        gb.gridy = 3;
        gb.insets = new Insets(20,0,0,0);
        add(inicioSesionJButton, gb);
    }

}
