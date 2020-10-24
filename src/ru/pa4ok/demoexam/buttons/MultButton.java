package ru.pa4ok.demoexam.buttons;

import ru.pa4ok.demoexam.type.Button;
import ru.pa4ok.demoexam.type.OperationTypeEnum;

public class MultButton extends Button
{
    public MultButton() {
        super("*");
    }

    @Override
    public double process(double value1, double value2) {
        return value1 * value2;
    }

    @Override
    public OperationTypeEnum getType() {
        return OperationTypeEnum.MULT;
    }
}
