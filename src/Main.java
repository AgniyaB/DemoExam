import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /*Human h1 = new Student("vasya", 21, false, 5);
        Human h2 = new Teacher("grin4pun", 60, false, "pp");

        //printAge(h1);
        //printAge(h2);

        List<Student> list = new ArrayList<>();
        //list.add((Student)h1);
        //list.add((Student)h2);
        //System.out.println(h1 instanceof Student);
        //System.out.println(h2 instanceof Student);
        if(h1 instanceof Student) {
            list.add((Student) h1);
        }
        if(h2 instanceof Student) {
            list.add((Student) h2);
        }

        System.out.println(list);


        //System.out.println(h1);
        //System.out.println(h2);*/

        Human human = new Human("sfqfew", 34, false);
        Student student = new Student("vasya", 21, false, 5);

        //human.work();
        student.work();
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
