public class Student extends Human
{
    private int level;

    public Student(String name, int age, boolean isWoman, int level)
    {
        super(name, age, isWoman);
        this.level = level;
    }

    @Override
    public void work() {
        super.work();
        System.out.println("work form Student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isWoman=" + isWoman +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
