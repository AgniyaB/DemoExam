package ru.pa4ok.demoexam;

//интерфейс может унаследовать интерфейс
public interface IDoubleSoundEntity extends ISoundEntity
{
    public void writeSecondSound();

    //можно переопределить default функции
    @Override
    default void doneFunction() {
        System.out.println("new test");
    }
}
