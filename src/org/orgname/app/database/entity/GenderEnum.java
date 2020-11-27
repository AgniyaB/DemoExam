package org.orgname.app.database.entity;

public enum GenderEnum
{
    MALE("Мужской"),
    FEMALE("Женский");

    private final String locale;

    GenderEnum(String locale)
    {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return this.locale;
    }
}
