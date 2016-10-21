package iteso.mx.UI.SalesTabs;

import iteso.mx.TableModels.ModifySellTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;


public class ModifySell extends JPanel{


   public ModifySell(){
       super(new GridLayout(1,0));
       ModifySellTableModel model = new ModifySellTableModel();
       Vector<Object> v = new Vector<Object>(Arrays.asList((Object)"1", (Object)"04-09-2015",(Object)"Aldo",(Object)"Juan",(Object)"000",
       (Object)"123", (Object)"789"));

       model.addRow(v);

       JTable table = new JTable(model);


       table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


       setLayout(new BorderLayout());
       add(table.getTableHeader(), BorderLayout.PAGE_START);
       add(table, BorderLayout.CENTER);
       add(table);
   }







}
