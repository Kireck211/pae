package iteso.mx.TableModels;

import iteso.mx.Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class ModifySellTableModel extends AbstractTableModel {
    String[] names = {"Folio",
            "Fecha",
            "Empleado",
            "Cliente",
            "Subtotal",
            "IVA",
            "Total"};
    Vector<String> columnNames;
    Vector<Vector<Object>> data;

   public ModifySellTableModel() {


       columnNames = (new Vector<String>(Arrays.asList(names)));
       data = new Vector<Vector<Object>>();


    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.elementAt(rowIndex).elementAt(columnIndex);
    }

    public void addRow(Vector<Object> row){
        data.add(row);
        fireTableRowsInserted(data.size() -1, data.size() - 1);
    }


}
