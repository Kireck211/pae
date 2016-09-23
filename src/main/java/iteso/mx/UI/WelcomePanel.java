package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class WelcomePanel extends JPanel{

    private JLabel welcomeJLabel;
    private JButton singInJButton;
    private JButton singUp;

    public WelcomePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        welcomeJLabel = new JLabel("Bienvenido");
        gb.weightx = .5;
        gb.gridx = 1;
        gb.gridy = 1;
        add(welcomeJLabel, gb);

        singInJButton = new JButton("Inicio Sesión");
        gb.gridx = 1;
        gb.gridy = 3;
        gb.insets = new Insets(20,0,0,0);
        add(singInJButton, gb);

        singUp = new JButton("Registrarse");
        gb.gridx = 1;
        gb.gridy = 5;
        add(singUp, gb);
    }

    public void addSignInListener(ActionListener actionListener) {
        singInJButton.addActionListener(actionListener);
    }

}
