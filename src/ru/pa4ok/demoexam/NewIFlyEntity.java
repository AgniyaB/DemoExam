package ru.pa4ok.demoexam;

//интерфесы могут наследовать друг друга
public interface NewIFlyEntity extends IFlyEntity
{
    //но нельзя реализовать заготовку (перевести из заготовки в дефотную)
    int getMaxFlyHeight();

    //можно переопределить дефотнуюфункцию
    @Override
    default int getSpeed() {
        return 100;
    }
}
