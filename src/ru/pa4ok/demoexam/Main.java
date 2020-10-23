package ru.pa4ok.demoexam;

public class Main
{
    /*
    крайний коммит с работой со школой
    https://github.com/Pa4ok/DemoExam/tree/36f5788f1d226e6eab8c259649b89c31974b3eae/src/ru/pa4ok/demoexam

    enum GenderEnum
    - MALE
    - FEMALE

    Human
    - String name
    - int age
    - GenderEnum gender

    Student extends Human
    - int level

    Teacher extends Human
    - String subject

    BuildingTypeEnum
    - SOCIAL
    - HOME
    - GOVERNMENT

    Building
    - String address
    - int floorCount
    - BuildingTypeEnum buildingType

    SchoolTypeEnum
    - PRIMARY
    - MEDIUM
    - HIGH

    School extends Building
    - int index
    - String name
    - SchoolTypeEnum schoolType
    - List<Teacher> teachers
    - List<Student> students
    - void addEntity(Human)
        метод принимает либой объект Human
        может быть как Student так и Teacher
        если это Teacher - кинуть к List<Teacher> teachers
        если это Student - кинуть к List<Student> students
     */

    public static void main(String[] args)
    {
        Human human = new Human("vasya", 15, GenderEnum.MALE);

        //сравнивать можно через ==
        //System.out.println(human.getGender() == GenderEnum.MALE);
        //human.setGender(GenderEnum.FEMALE);
        //System.out.println(human.getGender() == GenderEnum.MALE);

        //хорошо сравниваются свичами
        /*switch (human.getGender())
        {
            case FEMALE:
                System.out.println(1);
                break;
            case MALE:
                System.out.println(2);
                break;
        }*/

        //перебор всех значений
        /*for(GenderEnum g : GenderEnum.values()) {
            System.out.print(g + " ");
        }
        System.out.println();*/

        System.out.println(human);
    }
}
