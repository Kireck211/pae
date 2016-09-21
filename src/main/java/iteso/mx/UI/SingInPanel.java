package iteso.mx.UI;

import javax.swing.*;

public class SingInPanel extends JPanel{
    private JLabel userJLabel;
    private JLabel passwordJLabel;
    private JTextField userJTextField;
    private JTextField passwordJTextField;
    private JButton singIn;
    private JButton forgotten;

    public SingInPanel () {
        userJLabel = new JLabel("Usuario:");
        passwordJLabel = new JLabel("Contraseña");
        userJTextField = new JTextField();
        passwordJTextField = new JTextField();
        singIn = new JButton("Iniciar Sesión");
        forgotten = new JButton("¿Olvidaste tu contraseña?");
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        add(userJLabel);
        add(passwordJLabel);
        add(userJTextField);
        add(passwordJTextField);
        add(singIn);
        add(forgotten);
    }
}
