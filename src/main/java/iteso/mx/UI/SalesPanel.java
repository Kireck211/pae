package iteso.mx.UI;

import iteso.mx.UI.SalesTabs.Header;
import iteso.mx.UI.SalesTabs.ModifySell;
import iteso.mx.UI.SalesTabs.Sell;

import javax.swing.*;
import java.awt.*;

public class SalesPanel extends JPanel {
    public Sell sellPanel;
    public ModifySell modifySellPanel;
    public JTabbedPane tabbedPane;
    public Header header;

    public SalesPanel() {
        super(new BorderLayout());
        tabbedPane = new JTabbedPane();
        sellPanel = new Sell();
        modifySellPanel = new ModifySell();
        header = new Header();

        tabbedPane.add("Nueva Venta", sellPanel);
        tabbedPane.add("Modificar Venta",modifySellPanel);

        this.add(tabbedPane);
        this.add(header, BorderLayout.NORTH);
    }
}
