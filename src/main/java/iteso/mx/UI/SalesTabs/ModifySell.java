package iteso.mx.UI.SalesTabs;

import iteso.mx.TableModels.ModifySellTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Vector;

/**
 * Created by Erick on 06/10/2016.
 */
public class ModifySell extends JPanel{


   public ModifySell(){
       super(new GridLayout(1,0));


       JTable table = new JTable(new ModifySellTableModel());

       table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


       setLayout(new BorderLayout());
       add(table.getTableHeader(), BorderLayout.PAGE_START);
       add(table, BorderLayout.CENTER);
       add(table);
   }







}
