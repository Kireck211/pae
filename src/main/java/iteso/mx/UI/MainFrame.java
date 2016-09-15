package iteso.mx.UI;

import javax.swing.*;

public class MainFrame extends JFrame {

    public WelcomePanel welcomePanel;

    public MainFrame() {
        welcomePanel = new WelcomePanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(welcomePanel);
        setSize(200, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
