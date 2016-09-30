package iteso.mx;

import iteso.mx.UI.RegistrationPanel;
import iteso.mx.UI.SingInPanel;
import iteso.mx.UI.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

public class View extends JFrame {

    public WelcomePanel welcomePanel;
    public SingInPanel singInPanel;
    public RegistrationPanel registrationPanel;
    public CardLayout windowPicker;
    public JPanel windowsPanel;
    public final static String WELCOME_PANEL = "welcomePanel";
    public final static String SING_IN_PANEL = "singInPanel";
    public final static String REGISTRATION_PANEL = "registrationPanel";


    public View() {
        welcomePanel = new WelcomePanel();
        singInPanel = new SingInPanel();
        registrationPanel = new RegistrationPanel();

        windowsPanel = new JPanel(new CardLayout());
        windowsPanel.add(welcomePanel, WELCOME_PANEL);
        windowsPanel.add(singInPanel, SING_IN_PANEL);
        windowsPanel.add(registrationPanel,REGISTRATION_PANEL);

        windowPicker = (CardLayout)(windowsPanel.getLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        windowPicker.show(windowsPanel,WELCOME_PANEL);
        add(windowsPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
