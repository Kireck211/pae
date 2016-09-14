package iteso.mx.UI;

import javax.swing.*;

/**
 * Created by Erick on 14/09/2016.
 */
public class MainFrame extends JFrame {

    private BienvenidaPanel bienvenidaPanel;

    public MainFrame() {
        bienvenidaPanel = new BienvenidaPanel();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(bienvenidaPanel);
        this.setVisible(true);
    }
}
