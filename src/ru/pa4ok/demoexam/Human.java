package ru.pa4ok.demoexam;

public class Human
{
    //private boolean isWoman;
    private GenderEnum gender;

    public Human(GenderEnum gender) {
        this.gender = gender;
    }
}

enum GenderEnum
{
    MALE,
    FEMALE;
}
