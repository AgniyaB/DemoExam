package ru.pa4ok.demoexam;

public class Task
{
    /*
    Human
    - String name
    - int age
    - boolean isWoman
    - void nextYear() //age++

    Teacher extends Human
    - String subject
    - int exp
    - void nextYear() //родителькую и exp++

    Student extends Human
    - int level
    - void nextYear() //родителькую и level++

    Building
    - String address
    - int floorCount

    School extends Builder
    - int index
    - String name
    - List<Teacher> teachers
    - List<Student> students
    - public void addEntity(Human human)
        если human принадлежит к Teacher - добавить в список учителей
        если нет - добавить в список студент
    - void nextYear()
        перебирает всех студентов и преподавателей
        вызывает у них nextYear()
     */
}
