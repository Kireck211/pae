package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Erick on 29/09/2016.
 */
public class RegistrationPanel extends JPanel {
    private JLabel userJLabel;
    private JLabel passwordJLabel;
    private JTextField userJTextField;
    private JTextField passwordJTextField;
    private JButton oKJButton;
    private JButton cancelJButton;

    public RegistrationPanel() {
        userJLabel = new JLabel("Usuario:");
        passwordJLabel = new JLabel("Contraseña:");
        userJTextField = new JTextField(15);
        passwordJTextField = new JTextField(15);
        oKJButton = new JButton("Registrar");
        cancelJButton = new JButton("Cancelar");

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 2;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.fill = GridBagConstraints.NONE;
        add(userJLabel, gb);

        gb.gridy = 3;
        add(passwordJLabel, gb);

        gb.gridx = 1;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(userJTextField, gb);

        gb.gridy = 3;
        add(passwordJTextField, gb);

        gb.gridx = 0;
        gb.gridy = 4;
        gb.fill = GridBagConstraints.NONE;
        add(oKJButton, gb);

        gb.gridx = 1;
        add(cancelJButton, gb);

    }

    public void addOkListener(ActionListener actionListener) {
        oKJButton.addActionListener(actionListener);
    }

    public void addCancelListener(ActionListener actionListener) {
        cancelJButton.addActionListener(actionListener);
    }
}
