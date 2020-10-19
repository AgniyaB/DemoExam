package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        Human human = new Human("vasya", 15, GenderEnum.MALE);
        System.out.println(human);

        //System.out.println(human.getGender() == GenderEnum.MALE);

        /*for(GenderEnum g : GenderEnum.values()) {
            System.out.printf(g + " ");
        }
        System.out.println();*/

        /*switch (human.getGender())
        {
            case MALE:
                System.out.println(1);
                break;
            case FEMALE:
                System.out.println(2);
                break;
        }*/

        //сериализация из строки
        /*String s = "FEMALE";
        GenderEnum g = GenderEnum.valueOf(s);
        human.setGender(g);
        System.out.println(human);*/
    }

    /*
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
}
