public enum GenderEnum
{
    MALE("Мужчина"),
    FEMALE("Женщина");

    private final String translate;

    //можно сделать только приватный конструктор
    private GenderEnum(String translate)
    {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return this.translate.toUpperCase();
    }

    public String getTranslate() {
        return translate;
    }
}
