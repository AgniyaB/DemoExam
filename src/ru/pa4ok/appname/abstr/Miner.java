package ru.pa4ok.appname.abstr;

public class Miner extends WorkerHuman
{
    public Miner(String firstname, String surname, boolean isWoman, int age) {
        super(firstname, surname, isWoman, age);
    }

    @Override
    public String getWorkInfo() {
        return "Копает алмазы";
    }

    @Override
    public void work() {
        System.out.println("...копаю...");
    }

    public static void main(String[] args)
    {
        Miner miner = new Miner("name", "wdwddw", false, 33);
        System.out.println(miner.getWorkInfo());
        miner.work();

        System.out.println("\n");

        WorkerHuman workerHuman = new WorkerHuman("name-2", "wdwddw-2", true, 44)
        {
            @Override
            public String getWorkInfo() {
                return "new info";
            }

            @Override
            public void work() {
                System.out.println("...test...");
            }
        };
        System.out.println(workerHuman.getWorkInfo());
        workerHuman.work();
    }
}
