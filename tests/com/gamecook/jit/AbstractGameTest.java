package com.gamecook.jit;

import com.gamecook.jit.collections.Locations;
import com.gamecook.jit.commerce.Bank;
import com.gamecook.jit.items.AbstractItem;
import com.gamecook.jit.items.Item;
import com.gamecook.jit.time.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 18, 2010
 * Time: 8:43:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractGameTest
{
    private MockGame game;

    @Before
    public void setUp() throws Exception
    {
        game = new MockGame();
    }

    @After
    public void tearDown() throws Exception
    {
        game = null;
    }

    @Test
    public void testGetLocations() throws Exception
    {
        assertNotNull(game.getLocations());
        assertEquals(game.getLocations().getTotal(), 0);
    }

    @Test
    public void testSetLocations() throws Exception
    {
        Locations locations = new Locations();
        locations.add("LocationA");
        locations.add("LocationB");
        locations.add("LocationC");
        game.setLocations(locations);

        assertEquals(game.getLocations().getTotal(), 3);
    }

    @Test
    public void testGetBank() throws Exception
    {
        assertNotNull(game.getBank());
        assertEquals(game.getBank().getInterest(), 0.0);
    }

    @Test
    public void testSetBank() throws Exception
    {
        Bank bank = new Bank(100, 4.5);
        game.setBank(bank);
        assertEquals(game.getBank().getInterest(), 4.5);

    }

    @Test
    public void testGetCash() throws Exception
    {
        assertNotNull(game.getBank());
        assertEquals(game.getBank().getCash(), 0.0);
    }

    @Test
    public void testSetCash() throws Exception
    {
        Bank bank = game.getBank();
        bank.setCash(100);
        assertEquals(game.getBank().getCash(), 100.0);
    }

    @Test
    public void testGetCalendar() throws Exception
    {
        assertNotNull(game.getCalendar());
        assertEquals(game.getCalendar().getDays(), 0);
    }

    @Test
    public void testSetCalendar() throws Exception
    {

        game.setCalendar(new Calendar(30));
        assertEquals(game.getCalendar().getDays(), 30);

    }
}

class MockGame extends AbstractGame
{

    @Override
    public void nextTurn()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toString()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

class MockItem extends AbstractItem
{

    public MockItem(String name)
    {
        super(name);
    }

    @Override
    public Item clone()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}