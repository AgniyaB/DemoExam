package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.buttons.AddButton;
import ru.pa4ok.demoexam.buttons.DivButton;
import ru.pa4ok.demoexam.buttons.MultButton;
import ru.pa4ok.demoexam.buttons.SubButton;
import ru.pa4ok.demoexam.type.Button;
import ru.pa4ok.demoexam.type.IDefectiveOperational;
import ru.pa4ok.demoexam.type.OperationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator
{
    private List<Button> buttons = new ArrayList<>();
    private double firstValue = 0D;
    private double secondValue = 0D;
    private double result = 0D;

    public Calculator()
    {
        buttons.add(new AddButton());
        buttons.add(new SubButton());
        buttons.add(new MultButton());
        buttons.add(new DivButton());
    }

    public void readValues()
    {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите 1 число: ");
            firstValue = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите 2 число: ");
            secondValue = Double.parseDouble(scanner.nextLine());

        } catch (Exception e) {
            firstValue = 0D;
            secondValue = 0D;
            System.out.println("Неверный формат данных!");
        }

        scanner.close();
    }

    public void process(OperationTypeEnum type)
    {
        for(Button b : buttons)
        {
            if(b.getType() == type)
            {
                if(b instanceof IDefectiveOperational && !((IDefectiveOperational)b).canProcess(firstValue, secondValue)) {
                    System.out.println("Данную операцию выполнить нельзя (" + type + " | " + firstValue + " | " + secondValue + ")");
                    return;
                }
                result = b.process(firstValue, secondValue);
                System.out.println("Результат: " + result);
                return;
            }
        }
    }

    public void clear()
    {
        firstValue = 0D;
        secondValue = 0D;
        result = 0D;
    }
}
