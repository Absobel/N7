package manipulation;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

import tableur.Colonne;

public class MyTableModel extends AbstractTableModel {
    private Object[][] data; 
    private String[] columnNames;
    private boolean[] canEdit; 
    private Map<String, Colonne> columnMap;

    public MyTableModel(String[] columnNames, Object[][] data, boolean[] canEdit, Map<String, Colonne> columnMap) {
        this.columnNames = columnNames;
        this.data = data;
        this.canEdit = canEdit;
        this.columnMap = columnMap;
    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public Colonne getColonneByName(String name) {
        return columnMap.get(name);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
	public Map<String, Colonne> getColumnMap() {
		return columnMap;
	}
}
