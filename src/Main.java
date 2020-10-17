public class Main
{
    public static void main(String[] args)
    {
        Human human = new Human("vasya", 15, GenderEnum.MALE);

        //можно сравнивать через ==
        //System.out.println(human.getGender() == GenderEnum.MALE);

        //перебор всех значений
        /*for(GenderEnum g : GenderEnum.values()) {
            System.out.printf(g + " ");
        }
        System.out.println();*/

        //получение из строки
        /*String s = "FEMALE";
        GenderEnum genderEnum = GenderEnum.valueOf(s);
        System.out.println(genderEnum);*/

        //использование через switch
        /*switch(human.getGender())
        {
            case FEMALE:
                System.out.println(1);
                break;
            case MALE:
                System.out.println(2);
                break;
        }*/

        System.out.println(human);
    }
}
