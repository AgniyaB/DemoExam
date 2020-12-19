package org.orgname.app.util;


import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class CustomTableModel<T> extends AbstractTableModel
{
    /*
    нельзя путать class и Class
    class - это тип данных
    Class - частный случай типа данных который описывает типы данных
     */
    private Class<T> cls;

    private String[] columnNames;

    //тут хрянятся сущности из таблицы
    private List<T> values;

    public CustomTableModel(Class<T> cls, String[] columnNames, List<T> values)
    {
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
        //получаем массив со всеми зареегистрированными полями класса UserEntity
        //и получаем его размер
        return cls.getDeclaredFields().length;
    }

    @Override
    public String getColumnName(int column) {
        return column >= columnNames.length ? "NAME" : columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //также обращаемся в списку зарегистрированных полей
        //и так как мы связываем номер колонки с номером поля в классее
        //все работает
        return cls.getDeclaredFields()[columnIndex].getType();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            //таке получаем конкретное поле по номеру колонки
            Field field = cls.getDeclaredFields()[columnIndex];

            //делаем его доступными для чтения и записи
            //иначе при вызове field.get(...) вылетит IllegalAccessException
            field.setAccessible(true);

            //получаем значение поля из нужной сущности
            return field.get(values.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public List<T> getValues() {
        return values;
    }

    public CustomTableModel<T> setValues(List<T> values) {
        this.values = values;
        return this;
    }
}
