package iteso.mx.TableModels;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.Vector;

public class ModifySellTableModel extends AbstractTableModel {

    String[] names = {"Folio",
                      "Fecha",
                      "Empleado",
                      "PrecioBoleto",
                      "Cantidad",
                      "Subtotal",
                      "Total",
                        "Origen",
                        "Destino",
                        "Observaciones",
                        "Cliente"};

    Vector<String>  columnNames;
    Vector<Vector<Object>> data;

    public ModifySellTableModel(Vector<Vector<Object>> v){
        columnNames = (new Vector<String>(Arrays.asList(names)));
        data = v;
    }

    public ModifySellTableModel(){
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
        return (data.elementAt(rowIndex)).elementAt(columnIndex);
    }

    public void addRow(Vector<Object> row){
        data.add(row);
        fireTableRowsInserted(data.size() -1, data.size() - 1);
    }

    public void setValueAt(Object value, int row, int col) {
        (data.elementAt(row)).elementAt(col);
        fireTableCellUpdated(row, col);
    }

    public String getColumnName(int column){
        return columnNames.elementAt(column);
    }

    public void setData(Vector<Vector<Object>> data) {
         this.data = data;
         fireTableDataChanged();
    }
}
