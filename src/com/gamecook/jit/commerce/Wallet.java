package com.gamecook.jit.commerce;

public class Wallet {

    private double _cash = 0;

    /**
     * The wallet is a basic container for currency.
     * It simply allows you to store and retrieve
     * the value inside of it.
     *
     * @param value
     */
    public Wallet(double value) {
        _cash = value;
    }

    /**
     * Total in wallet.
     *
     * @return
     */
    public double getCash() {
        return _cash;
    }

    /**
     * Change the value of the total.
     *
     * @param value
     */
    public void setCash(double value) {
        _cash = value;
    }

    /**
     * Adds to the wallet's value.
     *
     * @param value
     */
    public double addCash(double value) {
        return _cash += value;
    }

    /**
     * Adds to the wallet's value.
     *
     * @param value
     */
    public double subtractCash(double value) {
        return _cash -= value;
    }
}