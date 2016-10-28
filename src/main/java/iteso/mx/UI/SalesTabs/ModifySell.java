package iteso.mx.UI.SalesTabs;

import iteso.mx.Model;
import iteso.mx.TableModels.ModifySellTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;


public class ModifySell extends JPanel{
    ModifySellTableModel tableModel;
    JTable table;
    JScrollPane scrollPane;
    JPanel panel2;

   public ModifySell(){
       super(new GridLayout(2,0));
       tableModel = new ModifySellTableModel();
       table = new JTable(tableModel);
       table.removeColumn(table.getColumnModel().getColumn(10));
       table.removeColumn(table.getColumnModel().getColumn(9));
       table.removeColumn(table.getColumnModel().getColumn(8));
       table.removeColumn(table.getColumnModel().getColumn(7));
       scrollPane = new JScrollPane(table);

       table.setFillsViewportHeight(true);

       add(scrollPane);
       panel2 = new ModifySellDetails();
       panel2.setSize(new Dimension(getWidth(),200));
       add(panel2);

   }

    public void setData(Vector<Vector<Object>> data){
        tableModel.setData(data);
    }




}
