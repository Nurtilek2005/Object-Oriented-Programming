package me.nurtilek2005.homework_3.task2;

import java.util.Comparator;

public class RankComparator implements Comparator<Freelancer> {
    @Override
    public int compare(Freelancer o1, Freelancer o2) {
        Rank rank1 = o1.getRank();
        Rank rank2 = o1.getRank();
        System.out.println(rank1.ordinal());
        System.out.println(rank2.ordinal());
        return 0;
    }
}
