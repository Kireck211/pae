package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;


public class RegistrationPanel extends JPanel {
    private JLabel userJLabel;
    private JLabel passwordJLabel;
    private JLabel nameL;
    private JLabel apL;
    private JLabel amL;
    private JLabel genderL;
    private JTextField userJTextField;
    private JTextField passwordJTextField;
    private JTextField nameTF;
    private JTextField apTF;
    private JTextField amTF;
    private JComboBox<String> genderTF;
    private JButton oKJButton;
    private JButton cancelJButton;

    public RegistrationPanel() {
        userJLabel = new JLabel("Usuario:");
        passwordJLabel = new JLabel("Contraseña:");
        nameL = new JLabel("Nombre:");
        apL = new JLabel("Apellido Paterno:");
        amL = new JLabel("Apellido Materno:");
        genderL = new JLabel("Sexo:");
        userJTextField = new JTextField(20);
        passwordJTextField = new JTextField(20);
        nameTF = new JTextField(20);
        apTF = new JTextField(20);
        amTF = new JTextField(20);
        genderTF = new JComboBox<String>(new Vector<String>(Arrays.asList("Femenino", "Masculino")));
        oKJButton = new JButton("Registrar");
        cancelJButton = new JButton("Cancelar");

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;

        // Add Labels
        gb.insets = new Insets(20,0,0,20);
        gb.gridy = 0;
        add(nameL, gb);

        gb.gridy += 1;
        add(apL, gb);

        gb.gridy += 1;
        add(amL, gb);

        gb.gridy += 1;
        add(genderL, gb);

        gb.gridy += 1;
        add(userJLabel, gb);

        gb.gridy += 1;
        add(passwordJLabel, gb);

        // Add textfields
        gb.insets = new Insets(20, 0, 0, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(nameTF, gb);

        gb.gridy += 1;
        add(apTF, gb);

        gb.gridy += 1;
        add(amTF, gb);

        gb.gridy += 1;
        add(genderTF, gb);

        gb.gridy += 1;
        add(userJTextField, gb);

        gb.gridy += 1;
        add(passwordJTextField, gb);

        // Add buttons
        gb.gridx = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridy += 1;
        gb.gridwidth = 2;
        add(oKJButton, gb);

        gb.gridy += 1;
        add(cancelJButton, gb);
    }

    public void addOkListener(ActionListener actionListener) {
        oKJButton.addActionListener(actionListener);
    }

    public void addCancelListener(ActionListener actionListener) {
        cancelJButton.addActionListener(actionListener);
    }

    public void eraseData() {
        userJTextField.setText("");
        passwordJTextField.setText("");
    }

    public String getUserTextField() {
        return userJTextField.getText();
    }

    public String getPasswordTextField() {
        return passwordJTextField.getText();
    }


    public String getNameTF() {
        return nameTF.getText();
    }

    public String getApTF() {
        return apTF.getText();
    }

    public String getAmTF() {
        return amTF.getText();
    }

    public String getGenderTF() {
        return (String) genderTF.getSelectedItem();
    }


}
