package org.orgname.app.util;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public abstract class ObjectTableModel<T> extends DefaultTableModel
{
    protected abstract T getEntityFromData(Object[] columns);

    protected abstract Object[] getDataFromEntity(T entity);

    public void addRowEntity(T entity)
    {
        addRow(getDataFromEntity(entity));
    }

    public void addRowEntities(List<T> entities) {
        entities.forEach(t -> addRowEntity(t));
    }

    public T getRowEntity(int row)
    {
        return getEntityFromData(getRowData(row));
    }

    public void setRowEntity(int row, T entity)
    {
        setRowData(row, getDataFromEntity(entity));
    }

    private Object[] getRowData(int row)
    {
        Object[] rowValues = new Object[getColumnCount()];
        for(int i=0; i<getColumnCount(); i++) {
            rowValues[i] = getValueAt(row, i);
        }
        return rowValues;
    }

    private void setRowData(int row, Object[] rowValues)
    {
        for(int i=0; i<getColumnCount(); i++) {
            setValueAt(rowValues[i], row, i);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
