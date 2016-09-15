package iteso.mx.UI;

import javax.swing.*;

public class SingInPanel extends JPanel{
    private JLabel userJLabel;
    private JLabel passwordJLabel;
    private JTextField userJTextField;
    private JTextField passwordJTextField;
    private JButton singUp;
    private JButton singIn;
    private JButton forgotten;

    public SingInPanel () {
        userJLabel = new JLabel("Usuario:");
        passwordJLabel = new JLabel("Contraseña");
        userJTextField = new JTextField();
        passwordJTextField = new JTextField();
        singUp = new JButton("Registrarse");
        singIn = new JButton("Iniciar Sesión");
        forgotten = new JButton("¿Olvidaste tu contraseña?");


        
    }
}
