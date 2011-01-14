package com.gamecook.jit.commerce;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 13, 2010
 * Time: 10:33:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankTest extends Bank
{

    public BankTest()
    {
        super(0, 0.1299);
        takeOutLoan(2500);
        deposit(30);

    }

    @Test
    public void testCalculateInterest()
    {
        assertEquals(calculateInterest(interest, 12, loan, 3), 81.0);
    }

    @Test
    public void testInterest()
    {
        nextDay(3, 12);
        assertEquals(getLoan(), 2581.0);

    }

    @Test
    public void testGetLoad()
    {
        assertEquals(getLoan(), 2500.0);
    }

    @Test
    public void testGetSavings()
    {
        assertEquals(getSavings(), 30.0);
    }

    @Test
    public void testGetInterest()
    {
        assertEquals(getInterest(), .1299);
    }

    @Test
    public void testPayOffLoan()
    {
        payOffLoan(1000);

        assertEquals(getLoan(), 1500.0);
    }

    @Test
    public void testTakeOutLoan()
    {
        takeOutLoan(500);
        assertEquals(getLoan(), 3000.0);
    }

    @Test
    public void testRemainderPayOffLoan()
    {
        double leftOver = payOffLoan(3000);
        assertEquals(leftOver, 500.0);
    }

    @Test
    public void testBalanceOverPayOffLoan()
    {
        //TODO This looks funny, why am I getting leftover?
        double leftOver = payOffLoan(3000);
        assertEquals(getLoan(), 0.0);
    }

    @Test
    public void testBalanceOverPayOffLoanReturn()
    {
        double leftOver = payOffLoan(3000);
        assertEquals(leftOver, 500.0);
    }

    @Test
    public void testGetMoney()
    {
        assertEquals(2470.0, getCash());
    }

    @Test
    public void testSetMoneyInWallet()
    {
        setCash(100);
        addCash(200);
        assertEquals(getCash(), 300.0);
    }

    @Test
    public void testSetInterest()
    {
        setInterest(1.12345);
        assertEquals(1.12345, getInterest());
    }

    @Test
    public void testDepositExactAmount()
    {
        setCash(100);
        setSavings(0);
        deposit(100);
        assertEquals(0.0, getCash());
        assertEquals(100.0, getSavings());
    }

    @Test
    public void testWithdrawExactAmount()
    {
        setCash(0);
        setSavings(100);
        withdraw(100);
        assertEquals(100.0, getCash());
        assertEquals(0.0, getSavings());
    }


    @Test
    public void testWithdrawMoreThenYouHave()
    {
        setCash(0);
        setSavings(100);
        withdraw(200);
        assertEquals(100.0, getCash());
        assertEquals(0.0, getSavings());
    }

    @Test
    public void testReplayLoanExactAmount()
    {
        setCash(100);
        setLoan(100);
        replayLoan(100);
        assertEquals(0.0, getLoan());
        assertEquals(0.0, getCash());
    }

    @Test
    public void testWithdrawFromSavingsExact()
    {
        setSavings(100);
        double amount = withdrawFromSavings(100);
        assertEquals(100.0, amount);
    }

    @Test
    public void testWithdrawFromSavingsOver()
    {
        setSavings(100);
        double amount = withdrawFromSavings(200);
        assertEquals(100.0, amount);
    }

    @Test
    public void testToString()
    {
        assertEquals(toString(), "{\"bank\":{\"savings\":30.0,\"interest\":0.1299,\"loan\":2500.0,\"round\":true,\"cash\":2470.0}}");
    }
}
