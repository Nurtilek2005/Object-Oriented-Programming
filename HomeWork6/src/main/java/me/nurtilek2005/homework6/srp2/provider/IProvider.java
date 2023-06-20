package me.nurtilek2005.homework6.srp2.provider;

public interface IProvider {
    default String getName() {
        return this.getClass().getSimpleName();
    }

    void save();
}
