package ru.pa4ok.demoexam;

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

        school.addEntity(new Student("vasya", 15, false, 6));
        school.addEntity(new Student("petya", 16, false, 7));
        school.addEntity(new Teacher("grin4pun", 60, false, "pp", 0));

        System.out.println(school);
        for(int i=0; i<3; i++) {
            school.nextYear();
        }
        System.out.println(school);
    }
}
