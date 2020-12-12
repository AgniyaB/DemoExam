package ru.pa4ok.appname.intrf;

import ru.pa4ok.appname.Human;

public class Businessmen extends Human implements IDirector
{
    public Businessmen(String firstname, String surname, boolean isWoman, int age) {
        super(firstname, surname, isWoman, age);
    }

    @Override
    public void work() {

    }

    @Override
    public void pay(int count) {

    }

    @Override
    public String toString() {
        return "Businessmen{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", isWoman=" + isWoman +
                ", age=" + age +
                '}';
    }
}
