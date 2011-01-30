package com.gamecook.jit.commerce;

import java.util.StringTokenizer;

public class Bank extends Wallet
{

    public static final int DEPOSIT = 0;
    public static final int WITHDRAW = 1;
    public static final int REPAY_LOAN = 2;
    public static final int GET_LOAN = 3;

    protected double savings = 0;
    protected double interest;
    protected double loan = 0;
    private Boolean round = true;

    /**
     * The bank manges a single loan and savings value.
     * It is capable of adding interest to the load each
     * day.
     *
     * @param interest
     */
    public Bank(double cash, double interest)
    {
        super(cash);
        this.interest = interest;
    }

    /**
     * Returns the total amount of savings in the bank.
     *
     * @return
     */
    public double getSavings()
    {
        return savings;
    }

    /**
     * Returns the total amount of the load in the bank.
     *
     * @return
     */
    public double getLoan()
    {
        return loan;
    }

    /**
     * Returns the interest used for the load.
     *
     * @return
     */
    public double getInterest()
    {
        return interest;
    }


    /**
     * Calculates the interest on the loan.
     *
     * @param currentDay
     * @param totalDays
     */
    public void nextDay(double currentDay, double totalDays)
    {
        if (loan != 0)
        {
            double interest = calculateInterest(this.interest, totalDays, loan, currentDay);
            loan += interest;
        }
    }

    /**
     * Pays off the loan. Returns the remainder if over.
     *
     * @param value
     * @return
     */
    public double payOffLoan(double value)
    {
        loan -= value;

        double remainder = 0;

        if (loan < 0)
        {
            remainder = loan * -1;
            loan = 0;
        }

        return remainder;

    }

    /**
     * takes money out of savings.
     *
     * @param value
     * @return
     */
    public double withdrawFromSavings(double value)
    {
        if (value > savings)
        {
            value = savings;
            savings = 0;
        } else
        {
            savings -= value;
        }

        return value;
    }

    /**
     * Increases the loan amount and your cash.
     *
     * @param value
     */
    public void takeOutLoan(double value)
    {
        loan += value;
        addCash(value);
    }

    protected double calculateInterest(double interest, double totalTime, double balance, double timeElapsed)
    {
        double value = ((interest / totalTime) * balance) * timeElapsed;

        return round ? Math.round(value) : value;
    }

    public void setInterest(double value)
    {
        interest = value;
    }

    public void setSavings(double value)
    {
        savings = value;
    }

    public void setLoan(double value)
    {
        loan = value;
    }

    /**
     * Adds money to your savings account from your cash
     *
     * @param value
     */
    public void deposit(double value)
    {
        //TODO need logic to make sure you can't deposit more then you have in cash
        subtractCash(value);
        savings += value;
    }

    public void withdraw(double value)
    {
        addCash(withdrawFromSavings(value));
    }

    public void replayLoan(double value)
    {
        //TODO need logic to make sure you can't replay more then you have or owe
        subtractCash(value);
        payOffLoan(value);
    }

    @Override
    public String toString()
    {
        String partial = "bank\":{"+
                "\"savings\":" + savings + "," +
                "\"interest\":" + interest + "," +
                "\"loan\":" + loan + "," +
                "\"round\":" + round + ",";

        return super.toString().replace("wallet\":{", partial);
    }

    public void setRound(boolean value)
    {
        this.round = value;
    }
}
