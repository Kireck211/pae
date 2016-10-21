package iteso.mx.UI.SalesTabs;

import iteso.mx.TableModels.ModifySellTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;


public class ModifySell extends JPanel{
    ModifySellTableModel model;
    JTable table;
    JScrollPane scrollPane;
   public ModifySell(){
       super(new GridLayout(2,0));

       model = new ModifySellTableModel();

       Vector<Object> v = new Vector<Object>(Arrays.asList((Object)"1", (Object)"04-09-2015",(Object)"Aldo",(Object)"Juan",(Object)"000",
       (Object)"123", (Object)"789"));

        model.addRow(v);


       table = new JTable(model);

       scrollPane = new JScrollPane(table);

       table.setFillsViewportHeight(true);

       add(scrollPane);
       JPanel panel2 = new JPanel();
       panel2.setSize(new Dimension(getWidth(),200));
       add(panel2);

   }







}
