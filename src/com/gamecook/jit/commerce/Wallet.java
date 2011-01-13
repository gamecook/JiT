package com.gamecook.jit.commerce;

public class Wallet
{

    private double cash = 0;

    /**
     * The wallet is a basic container for currency.
     * It simply allows you to store and retrieve
     * the value inside of it.
     *
     * @param value
     */
    public Wallet(double value)
    {
        cash = value;
    }

    /**
     * Total in wallet.
     *
     * @return
     */
    public double getCash()
    {
        return cash;
    }

    /**
     * Change the value of the total.
     *
     * @param value
     */
    public void setCash(double value)
    {
        cash = value;
    }

    /**
     * Adds to the wallet's value.
     *
     * @param value
     */
    public double addCash(double value)
    {
        return cash += value;
    }

    /**
     * Adds to the wallet's value.
     *
     * @param value
     */
    public double subtractCash(double value)
    {
        return cash -= value;
    }

    @Override
    public String toString()
    {
        return "{\"wallet\":{"+
                "\"cash\":" + cash + "}" +
                "}";
    }
}