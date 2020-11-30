package org.orgname.app.util;

import org.orgname.app.database.entity.UserEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class ObjectTableModel<T> extends DefaultTableModel
{
    protected abstract T getEntityFromData(Object[] columns);

    protected abstract Object[] getDataFromEntity(T t);

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void addRow(T t) {
        addRow(getDataFromEntity(t));
    }

    public T getEntity(int row)
    {
        if(getRowCount() < row) {
            return null;
        }

        return getEntityFromData(getDataFromRow(row));
    }

    private Object[] getDataFromRow(int row)
    {
        Object[] rowValues = new Object[getColumnCount()];
        for(int i=0; i<getColumnCount(); i++) {
            rowValues[i] = getValueAt(row, i);
        }
        return rowValues;
    }

    public void sort(Comparator<T> comparator)
    {
        List<T> list = new ArrayList<>();
        for(int i=0; i<getRowCount(); i++) {
            list.add(getEntity(i));
        }

        Collections.sort(list, comparator);

        while(getRowCount() > 0) {
            removeRow(0);
        }
        for(T t : list) {
            addRow(t);
        }
    }
}
