package ru.pa4ok.appname;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        //List<String> list = new ArrayList<>();

        Container<String> stringContainer = new Container<>("wdhuwdhuwd");
        System.out.println(stringContainer);

        Container<Integer> integerContainer = new Container<>(344343);
        System.out.println(integerContainer);

        NumberContainer<Integer> integerNumberContainer = new NumberContainer<>(322332);
        NumberContainer<Double> doubleNumberContainer = new NumberContainer<>(3432434D);
        //так как String не наследует Number сделать такой генерик нельзя
        //NumberContainer<String> stringNumberContainer = new NumberContainer<String>("32323232");
    }
}

//генерик объявляется 1 раз после названия класса
//и дальше может использоваться почти в любых метах класса
class Container<T>
{
    private T value;

    public Container(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Container{" +
                "value=" + value +
                '}';
    }

    //генерик можно проверять на принадлежноть к типу
    public void test()
    {
        if(value instanceof String) {
            String s = (String)value;
            //...
        }
    }

    public T getValue() {
        return value;
    }

    public Container<T> setValue(T value) {
        this.value = value;
        return this;
    }
}

//аналогичное использование в интерфейсах
interface ITestInterface<T>
{
    public T generateValue(int a);
}

//генерик можно ограничить до какого типа данных
//те в него можно будет положить объект класса Number
//или объекты классов которые наследуют Number
class NumberContainer<T extends Number>
{
    public T number;

    public NumberContainer(T number) {
        this.number = number;
    }
}

//в классе может быть несколько генериков
class DoubleContainer<T,K>
{
    T value1;
    K value2;

    public DoubleContainer(T value1, K value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}

//можно унаследовать и задать постоянный тип
class SuperIntegerContainer extends Container<Integer>
{
    public SuperIntegerContainer(Integer value) {
        super(value);
    }
}

//можно унаследовать и оставить генерик
class SuperContainer<T> extends Container<T>
{
    public SuperContainer(T value) {
        super(value);
    }
}

//при наследовании ограниченного генерика необходимо учитывать ограничения
class SuperNumberContainer<T extends Number> extends NumberContainer<T>
{
    public SuperNumberContainer(T number) {
        super(number);
    }
}

