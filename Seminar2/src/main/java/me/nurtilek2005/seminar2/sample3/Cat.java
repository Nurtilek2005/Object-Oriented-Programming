package me.nurtilek2005.seminar2.sample3;

public class Cat extends BaseCat implements Runner {

    private final int maxRun;
    private final int maxJump;
    private final String name;

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public String getName() {
        return name;
    }

    public Cat(int maxRun, int maxJump, String name) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.name = name;
    }


}
