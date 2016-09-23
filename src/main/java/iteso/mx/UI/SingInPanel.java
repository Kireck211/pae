package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;

public class SingInPanel extends JPanel{
    private JLabel userJLabel;
    private JLabel passwordJLabel;
    private JTextField userJTextField;
    private JTextField passwordJTextField;
    private JButton singIn;
    private JButton forgotten;

    public SingInPanel () {
        userJLabel = new JLabel("Usuario:");
        userJTextField = new JTextField(15);
        passwordJLabel = new JLabel("Contraseña");
        passwordJTextField = new JTextField(15);
        forgotten = new JButton("¿Olvidaste tu contraseña?");

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.fill = GridBagConstraints.NONE;


        add(userJLabel, gb);

        gb.gridy = 1;
        add(passwordJLabel, gb);


        gb.gridx = 1;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new Insets(0,0,0,20);
        add(userJTextField, gb);

        gb.insets = new Insets(0,0,0,0);


        gb.fill = GridBagConstraints.NONE;
        gb.gridy = 2;
        add(forgotten, gb);


        gb.gridx = 0;
        gb.gridy = 3;
        gb.insets = new Insets(0,0,0,0);
        add(passwordJLabel, gb);


        gb.gridx = 2;
        gb.gridy = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(passwordJTextField, gb);

        singIn = new JButton("Iniciar Sesión");
        gb.weightx = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 4;
        gb.insets = new Insets(20,0,0,0);
        add(singIn, gb);
    }
}
