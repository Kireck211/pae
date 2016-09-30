package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SingInPanel extends JPanel{
    private JLabel userJLabel;
    private JLabel passwordJLabel;
    private JTextField userJTextField;
    private JTextField passwordJTextField;
    private JButton singIn;
    private JButton forgotten;
    private JButton cancel;

    public SingInPanel () {
        userJLabel = new JLabel("Usuario:");
        userJTextField = new JTextField(15);
        passwordJLabel = new JLabel("Contraseña:");
        passwordJTextField = new JTextField(15);
        forgotten = new JButton("¿Olvidaste tu contraseña?");
        singIn = new JButton("Iniciar Sesión");
        cancel = new JButton("Cancelar");

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 2;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.insets = new Insets(60,0,0,0);
        gb.fill = GridBagConstraints.NONE;
        add(userJLabel, gb);

        gb.gridy = 3;
        gb.insets = new Insets(0,0,0,0);
        add(passwordJLabel, gb);

        gb.gridx = 1;
        gb.gridy = 2;
        gb.insets = new Insets(60,0,0,20);
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(userJTextField, gb);

        gb.gridy = 3;
        gb.insets = new Insets(0,0,0,20);
        add(passwordJTextField, gb);

        gb.gridx = 1;
        gb.gridy = 4;
        add(forgotten, gb);

        gb.gridwidth = 2;
        gb.insets = new Insets(0,20,0,20);
        gb.gridx = 0;
        gb.gridy = 5;
        add(singIn, gb);

        gb.gridy = 6;
        add(cancel, gb);
    }

    public void eraseData() {
        userJTextField.setText("");
        passwordJTextField.setText("");
    }

    public void addForgottenPasswordListener(ActionListener actionListener) {
        forgotten.addActionListener(actionListener);
    }

    public void addSignInListener(ActionListener actionListener) {
        singIn.addActionListener(actionListener);
    }

    public void addCancelListener(ActionListener actionListener) {
        cancel.addActionListener(actionListener);
    }
}
