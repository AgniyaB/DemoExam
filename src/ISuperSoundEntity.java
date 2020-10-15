public interface ISuperSoundEntity extends ISoundEntity
{
    @Override
    public default String getSound() {
        return "";
    }

    @Override
    default void doneFunction() {
        System.out.println("new fuction");
    }
}
