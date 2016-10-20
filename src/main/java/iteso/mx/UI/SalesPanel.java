package iteso.mx.UI;

import iteso.mx.UI.SalesTabs.ModifySell;
import iteso.mx.UI.SalesTabs.Refund;
import iteso.mx.UI.SalesTabs.Sell;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SalesPanel extends JPanel {
    public Sell sellPanel;
    public ModifySell modifySellPanel;
    public Refund refundPanel;
    public JTabbedPane tabbedPane;

    public SalesPanel() {
        super(new GridLayout(1, 1));
        tabbedPane = new JTabbedPane();
        sellPanel = new Sell();
        modifySellPanel = new ModifySell();
        refundPanel = new Refund();


        tabbedPane.add("Nueva Venta", sellPanel);
        tabbedPane.add("Modificar Venta",modifySellPanel);

        this.add(tabbedPane);
    }
}
