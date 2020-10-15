import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        School school = new School(
                "spb",
                4,
                1,
                "fspo"
        );

        System.out.println(school);
        school.addEntity(new Teacher("grin4pun", 60, false, "pp", 20));
        school.addEntity(new Student("vasya", 15, false, 5));
        school.addEntity(new Student("ira", 17, true, 8));
        school.addEntity(new Human("armen", 30, false));
        System.out.println(school);
        for(int i=0; i<4; i++) {
            school.nextYear();
        }
        System.out.println(school);
    }


    private static void printAge(Human h) {
        System.out.println(h.getAge());
    }

    /*
    Human
    - String name
    - int age
    - boolean isWoman
    - void nextYear() //age++

    Student extends Human
    - int level
    - void nextYear() //родителький и level++

    Teacher extends Human
    - String subject
    - int exp
    - void nextYear() //родителький и exp++

    Building
    - String address
    - int floorCount

    School extends Building
    - int index
    - String name
    - List<Teacher> teachers
    - List<Student> students
    - void addEntity(Human human)
        //проверить если
        //human это Teacher то добавить в teachers
        //если это Student то в students
        //если нет то вывести в консоль
    - void nextYear()
        //перебирать всех студентов и преподавателей
        //и вызывать у них nextYear()
        //если у студента level >= 12 его нужно удалить
     */
}
