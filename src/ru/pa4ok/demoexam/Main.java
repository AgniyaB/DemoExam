package ru.pa4ok.demoexam;

import java.util.*;

public class Main
{
    /*
    enum OperationTypeEnum
    - ADD
    - SUB
    - MULT
    - DIV

    interface IOperational
    - public double process(double, double)
    - public OperationTypeEnum getType()

    interface IDefectiveOperational
    - public boolean canProcess(double, double)
    //деление будет через этот интерфес для проверки на 0

    abstract Button implements IOperational
    - String title

    SomeButton extends Button
    DivButton extends Button implements IDefectiveOperational

    Calculator
    - List<Button> buttons // +заполнить кнопками с операциями
    - double firstValue
    - double secondValue
    - double result
    - public void readValues()
        запросить чтение firstValue и secondValue
    - public void process(OperationTypeEnum type)
        перебрать все кнопки
        найти кнопку с нужным типом операции
        проверить на IDefectiveOperational, если все ок
        нажать, при нажатии вывести название кнопки
    - public void clear()
        очистить поля и результат

     */

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextDouble();
        Double.parseDouble(scanner.nextLine());
        scanner.close();
    }
}
