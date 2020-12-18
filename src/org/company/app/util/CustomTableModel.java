package org.company.app.util;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

/*
    главный минус - это то что в классе сущности не должно быть лишних полей
 */
public class CustomTableModel<T> extends AbstractTableModel
{
    //не путатать Class и class
    //class - тип данных в общем
    //Class - тип данных который описывает типы данных
    private final Class<T> cls;

    private final String[] columnNames;

    //коллекция для всех строк таблицы
    private List<T> values;

    public CustomTableModel(Class<T> cls, String[] columnNames, List<T> values) {
        this.cls = cls;
        this.columnNames = columnNames;
        this.values = values;
    }

    @Override
    public int getRowCount() {
        return values.size();
    }

    @Override
    public int getColumnCount() {
        //получаем массив всех зарегистрированных полей и возвращаем его длину
        return cls.getDeclaredFields().length;
    }

    @Override
    public String getColumnName(int column) {
        return column >= columnNames.length ? "NAME" : columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //получаем массив всех зарегистрированных полей и возвращаем класс поля по номеру колонки
        return cls.getDeclaredFields()[columnIndex].getType();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            //получаем поле по индексу колонки
            Field field = cls.getDeclaredFields()[columnIndex];
            //делаем его доступным для взаимодействия
            field.setAccessible(true);
            //получаем значение поля из объета коллекции по номеру строки
            return field.get(values.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public CustomTableModel<T> setValues(List<T> values) {
        this.values = values;
        return this;
    }

    public List<T> getValues() {
        return values;
    }
}
