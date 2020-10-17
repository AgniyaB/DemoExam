public class Main
{
    public static void main(String[] args)
    {
        Human human = new Human("paul", 25, GenderEnum.MALE);

        //сравнивать энумы можно через ==
        //System.out.println(human.getGender() == GenderEnum.MALE);

        //можно нормально сравнивать черезе switch
        /*switch (human.getGender())
        {
            case MALE:
                System.out.println("male");
                break;

            case FEMALE:
                System.out.println("female");
                break;
        }*/

        //сериализация из строки
        /*String s = "MALE";
        GenderEnum genderEnum = GenderEnum.valueOf(s);
        System.out.println(genderEnum);*/

        //перебор всех значений
        /*for(GenderEnum g : GenderEnum.values()) {
            System.out.printf(g + " ");
        }
        System.out.println();*/

        System.out.println(human);
    }


     /*
    abstract Human
    - String name
    - int age
    - Gender gender

    enum Gender
    - MALE
    - FEMALE

    Student extends Human
    - int level //класс

    Teacher extends Human
    - String subject
    - int exp //стаж

    abstract Building
    - String address
    - int floorCount
    - BuildingType type

    enum BuildingType
    - SOCIAL
    - HOUSE
    - GOVERNMENT
    - TRASH

    School extends Building
    - int index
    - String title
    - List<Teacher> teachers
    - List<Student> students
     */
}
