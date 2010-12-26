package com.gamecook.jit.items;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;
import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 16, 2010
 * Time: 4:04:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractItemTest extends AbstractItem {

    public AbstractItemTest()
    {
        super("AbstractItemTest");
    }
    
    @Before
    public void setUp(){
        
    }

    @Test
    public void testSetMinPriceLowerThenZero(){
        setMinPrice(-5);
        assertEquals(minPrice, 0.0);
    }

    @Test
    public void testGetSetMinPrice(){
        setMinPrice(1);
        assertEquals(minPrice, 1.0);
    }

    @Test
    public void testSetGetMaxPrice(){
        setMaxPrice(10);
        assertEquals(maxPrice,10.0);
    }

    @Test
    public void testSetMaxPriceLowerThenMinPrice(){
        setMinPrice(5);
        setMaxPrice(1);
        assertEquals(maxPrice,5.0);
    }

    @Test
    public void testSetMaxPrice(){
        setMaxPrice(100);
        assertEquals(maxPrice, 100.0);
    }

    @Test
    public void testGetSetPrice(){
        setPrice(10);
        assertEquals(price, 10.0);
    }

    @Test
    public void testSetPriceLowerThenZero(){
        setPrice(-10);
        assertEquals(price, 0.0);
    }

    @Test
    public void testGetSetName(){
        assertEquals(name, "AbstractItemTest");
    }

    @Test
    public void testGetSetDescription(){

        setDescription("This is a simple test");
        assertEquals(description, "This is a simple test");
    }

    @Test
    public void testGenerateNewPrice(){
        setMinPrice(1);
        setMaxPrice(10);
        setPrice(0);
        generateNewPrice();
        assertTrue(price <= maxPrice && price >= minPrice);
    }

    @Test
    public void testGetSetTotal()
    {
        setTotal(100);
        assertEquals(total, 100);
    }

    @Test
    public void testSetTotalLessThenZero()
    {
        setTotal(-50);
        assertEquals(total, 0);
    }

    @Override
    public Item clone(String name) {
        return null;
    }

    @Test
    public void testHistory()
    {
        int total = 5;
        int i;

        //Populate prices
        for (i = 0; i < total; i++)
        {
            setPrice(i * 10);
        }

        for (i = 0; i < total; i++)
        {
            double price = getPriceHistory().get(i);
            assertEquals(price, ((double)i * 10));
        }
    }

    @Test
    public void testHistoryToString()
    {
       int total = 5;
        int i;

        //Populate prices
        for (i = 0; i < total; i++)
        {
            setPrice(i);
        }

        assertEquals(priceHistoryToString(","), "0.0,1.0,2.0,3.0,4.0");
    }

    @Test
    public void testParseHistoryFromString()
    {
        priceHistory.clear();
        String prices = "0.0, 1.0, 1.5, 2.1543";
        parsePriceHistoryString(prices);
        assertEquals(priceHistory.get(0), 0.0);
        assertEquals(priceHistory.get(1), 1.0);
        assertEquals(priceHistory.get(2), 1.5);
        assertEquals(priceHistory.get(3), 2.1543);
    }

    @Test
    public void testToString()
    {
        int total = 5;
        int i;

        //Populate prices
        for (i = 0; i < total; i++)
        {
            setPrice(i * 10);
        }

        assertEquals(toString(), "{\"name\":\"AbstractItemTest\",\"minPrice\":0.0,\"maxPrice\":0.0,\"price\":40.0,\"total\":0,\"description\":\"\",\"history\":[0.0,10.0,20.0,30.0,40.0],\"active\":"+active+"}");
    }
}
