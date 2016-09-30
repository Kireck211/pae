package iteso.mx;

import iteso.mx.UI.SingInPanel;
import iteso.mx.UI.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

public class View extends JFrame {

    public WelcomePanel welcomePanel;
    public SingInPanel singInPanel;
    public CardLayout windowPicker;
    public JPanel windowsPanel;
    public static String WELCOME_PANEL = "welcomePanel";
    public static String SING_IN_PANEL = "singInPanel";


    public View() {
        welcomePanel = new WelcomePanel();
        singInPanel = new SingInPanel();

        windowsPanel = new JPanel(new CardLayout());
        windowsPanel.add(welcomePanel, WELCOME_PANEL);
        windowsPanel.add(singInPanel, SING_IN_PANEL);

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
