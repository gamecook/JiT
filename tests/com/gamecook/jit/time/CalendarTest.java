package com.gamecook.jit.time;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 13, 2010
 * Time: 9:52:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalendarTest
{

    @Test
    public void testCreateCalendar()
    {
        Calendar cal = new Calendar(10);
        assertEquals(cal.getDays(), 10);
    }

    @Test
    public void testHasNextDayPass()
    {
        Calendar cal = new Calendar(10);
        cal.nextDay();
        assertTrue(cal.hasNextDay());
    }

    @Test
    public void testHasNextDayFail()
    {
        Calendar cal = new Calendar(1);
        cal.nextDay();
        assertFalse(cal.hasNextDay());
    }

    @Test
    public void testNextDay()
    {
        Calendar cal = new Calendar(10);
        cal.nextDay();
        assertEquals(cal.getDays(), 9);
    }

    @Test
    public void testTotalDays()
    {
        Calendar cal = new Calendar(10);
        cal.nextDay();
        assertEquals(cal.getTotalDays(), 10);
    }

    @Test
    public void testNextDayBy5()
    {
        Calendar cal = new Calendar(10);
        cal.nextDay();
        cal.nextDay();
        cal.nextDay();
        cal.nextDay();
        cal.nextDay();
        assertEquals(cal.getDays(), 5);
    }

    @Test
    public void testSetTotalDays()
    {
        Calendar cal = new Calendar(0);
        cal.setTotalDays(100);
        assertEquals(cal.getTotalDays(), 100);
    }

    @Test
    public void testToString()
    {
        Calendar cal = new Calendar(10);
        assertEquals(cal.toString(), "\"calendar\":{\"days\":10,\"totalDays\":10}");
    }

}
