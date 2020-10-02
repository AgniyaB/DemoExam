package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /*//Human human = new Human("Vasya", 12);
        //System.out.println(human);

        Teacher teacher = new Teacher("Petya", 40, "math");
        //System.out.println(teacher);

        //human.work();
        //teacher.work();

        Human human = new Teacher("Vasya", 35, "pp");
        System.out.println(human);

        System.out.println(human instanceof Student);
        System.out.println(human instanceof Teacher);
*/
        /*List<Teacher> teacherList = new ArrayList<>()
        if(human instanceof Teacher) {
            //Teacher t = (Teacher)human;
            teacherList.add((Teacher)human);
            System.out.println(((Teacher)human).getSubject());
        }
        Arrays.asList(1, 2, 3);*/

        School school = new School("adreesssss", 4, 1, "fspo");
        System.out.println(school);
        school.addEntity(new Teacher("grin4pun",50, false, "pp"));
        school.addEntity(new Student("Vasya", 15, false, 5));
        System.out.println(school);
    }


    /*Human
    - String name
    - int age
    - boolean isWoman
    - toString()

    Student extends Human
    - int level
    - toString()

    Teacher extends Human
    - String subject
    - toString()

    Building
    - String adress
    - int floorCount
    - toString()

    School extends Building
    - int index
    - String name
    - List<Teacher> teachers
    - List<Student> students
    - toString()
    - void addEntity(Human)
        метод принимает либой объект Human
        может быть как Student так и Teacher
        если это Teacher - кинуть к List<Teacher> teachers
        если это Student - кинуть к List<Student> students
     */
}
