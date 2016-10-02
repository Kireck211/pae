package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by simio on 02/10/2016.
 */
public class SalesPanel extends JPanel {


    public SalesPanel() {
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();

        JComponent newSale = makeComponent("Tab1");
        tabbedPane.add("Nueva Venta",newSale);

        JComponent modifySale = makeComponent("Tab2");
        tabbedPane.add("Modificar Venta",modifySale);

        this.add(tabbedPane);

    }

    private JComponent makeComponent(String name){
        JPanel panel = new JPanel();
        JLabel filler = new JLabel(name);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

}
