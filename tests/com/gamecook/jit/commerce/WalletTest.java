package com.gamecook.jit.commerce;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 13, 2010
 * Time: 11:13:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class WalletTest
{

    @Test
    public void testNewWallet()
    {
        Wallet wallet = new Wallet(100);
        assertEquals(wallet.getCash(), 100.0);
    }

    @Test
    public void testSetMoneyInWallet()
    {
        Wallet wallet = new Wallet(100);
        wallet.addCash(200);
        assertEquals(wallet.getCash(), 300.0);
    }

    @Test
    public void testSubtractCash()
    {
        Wallet wallet = new Wallet(100);
        wallet.subtractCash(50);
        assertEquals(50.0, wallet.getCash());
    }

    @Test
    public void testToString()
    {
        Wallet wallet = new Wallet(100);
        assertEquals(wallet.toString(), "\"wallet\":{\"cash\":100.0}");
    }
}
