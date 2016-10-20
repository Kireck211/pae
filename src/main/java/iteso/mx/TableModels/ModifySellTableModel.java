package iteso.mx.TableModels;

import iteso.mx.Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by Aldo on 20/10/2016.
 */
public class ModifySellTableModel extends Model implements TableModel {
    String[] names = {"Folio",
            "Fecha",
            "Empleado",
            "Cliente",
            "Subtotal",
            "IVA",
            "Total"};
    Vector<String> columnNames = (new Vector<String>(Arrays.asList(names))) ;
    Vector<Vector<Object>> data;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.elementAt(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.elementAt(rowIndex).elementAt(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        (data.elementAt(rowIndex)).set(columnIndex, aValue);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
