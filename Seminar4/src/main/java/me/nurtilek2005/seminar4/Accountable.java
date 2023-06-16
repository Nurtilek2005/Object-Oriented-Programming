package me.nurtilek2005.seminar4;

public interface Accountable<T> {

    T getId();

    double getAmount();

    void setAmount(double amount);

}
