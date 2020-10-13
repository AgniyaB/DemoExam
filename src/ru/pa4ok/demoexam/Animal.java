package ru.pa4ok.demoexam;

public class Animal extends EntityLiving
{
    protected boolean canPet;
    protected boolean hasSound;
    protected String sound;

    public Animal(String type, boolean canPet, String sound) {
        super(type);
        this.canPet = canPet;
        this.sound = sound;
        if(this.sound != null) {
            hasSound = true;
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "canPet=" + canPet +
                ", hasSound=" + hasSound +
                ", sound='" + sound + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public boolean isCanPet() {
        return canPet;
    }

    public void setCanPet(boolean canPet) {
        this.canPet = canPet;
    }

    public boolean isHasSound() {
        return hasSound;
    }

    public void setHasSound(boolean hasSound) {
        this.hasSound = hasSound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
