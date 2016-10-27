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

   public ModifySell(){
       super(new GridLayout(2,0));

       table = new JTable(tableModel);

       scrollPane = new JScrollPane(table);

       table.setFillsViewportHeight(true);

       add(scrollPane);
       JPanel panel2 = new JPanel();
       panel2.setSize(new Dimension(getWidth(),200));
       add(panel2);

   }

    public void setData(Vector<Vector<Object>> data){
        tableModel.setData(data);
    }




}
