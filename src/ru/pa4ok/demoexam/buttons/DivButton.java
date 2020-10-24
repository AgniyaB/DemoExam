package ru.pa4ok.demoexam.buttons;

import ru.pa4ok.demoexam.type.Button;
import ru.pa4ok.demoexam.type.IDefectiveOperational;
import ru.pa4ok.demoexam.type.OperationTypeEnum;

public class DivButton extends Button implements IDefectiveOperational
{
    public DivButton() {
        super("/");
    }

    @Override
    public boolean canProcess(double value1, double value2) {
        return value2 != 0;
    }

    @Override
    public double process(double value1, double value2) {
        return value1 / value2;
    }

    @Override
    public OperationTypeEnum getType() {
        return OperationTypeEnum.DIV;
    }
}
