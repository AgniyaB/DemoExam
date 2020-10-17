public interface IFlyEntity
{
    public int getMaxFlyTime();

    public double getMaxFlyHeight();
}

/*
interface ISuperFlyEntity extends IFlyEntity
{
    @Override
    public default int getMaxFlyTime() {
        return 120;
    }

    public String getTest();
}*/
