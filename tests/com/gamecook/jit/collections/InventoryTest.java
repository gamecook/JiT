package com.gamecook.jit.collections;


import com.gamecook.jit.items.Item;
import com.gamecook.jit.items.MockItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.*;
import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 14, 2010
 * Time: 10:14:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryTest
{

    private Inventory inventory;

    @Before
    public void setUp() throws Exception
    {
        inventory = new Inventory(100);

        // Item A
        Item itemA = new MockItem("Item A");
        itemA.setMinPrice(1);
        itemA.setMaxPrice(10);
        inventory.add(itemA, 1);

        // Item B
        Item itemB = new MockItem("Item B");
        itemB.setMinPrice(10);
        itemB.setMaxPrice(20);
        inventory.add(itemB, 10);

        // Item C
        Item itemC = new MockItem("Item C");
        itemC.setMinPrice(20);
        itemC.setMaxPrice(30);
        inventory.add(itemC, 4);
    }

    @Test
    public void testAdd() throws Exception
    {
        Item itemD = new MockItem("Item D");

        inventory.add(itemD, 1);

        Item itemDInStore = inventory.get("Item D");

        assertEquals(itemD, itemDInStore);
        assertEquals(itemDInStore.getTotal(), 1);
    }

    @Test
    public void testRemove() throws Exception
    {
        assertTrue(inventory.remove("Item B"));
    }

    @Test
    public void testRemoveFail() throws Exception
    {
        assertFalse(inventory.remove("Item X"));
    }

    @Test
    public void testGetItem()
    {
        assertNotNull(inventory.get("Item A"));
    }

    @Test
    public void testGetTotalItems()
    {
        assertEquals(inventory.getTotalItems(), 3);
    }

    @Test
    public void testGetItemTotal()
    {
        assertEquals(inventory.getItemTotal("Item B"), 10);
    }

    @Test
    public void testAddToItemTotal()
    {
        assertEquals(inventory.addToItemTotal("Item B", 20), 30);

    }

    @Test
    public void testAddItemThatExists()
    {
        Item tmpItem = new MockItem("Item B");
        inventory.setMaxTotal(-1);
        inventory.add(tmpItem, 100);
        assertEquals(inventory.get("Item B").getTotal(), 110);
    }

    @Test
    public void testRemoveItemIsNull()
    {
        Item tmpItem = new MockItem("FooBar");
        inventory.add(tmpItem, 10);
        inventory.removeFromInventory(tmpItem, 10);
        assertNull(inventory.get("FooBar"));
    }

    @Test
    public void testRemoveFromInventory()
    {
        Item tmpItem = new MockItem("FooBar");
        inventory.add(tmpItem, 10);
        assertEquals(inventory.removeFromInventory(tmpItem, 5), 5);
        assertEquals(inventory.getItemTotal("FooBar"), 5);
    }

    @org.junit.Test(expected = Error.class)
    public void testMaxInventory()
    {
        Item tmpItem = new MockItem("FooBar");
        inventory.add(tmpItem, 200);
    }

    @Test
    public void testCurrentTotal()
    {
        Item tmpItem = new MockItem("FooBar");
        inventory.add(tmpItem, 10);

        Item tmpItem2 = new MockItem("FooBar2");
        inventory.add(tmpItem2, 10);

        Item tmpItem3 = new MockItem("FooBar3");
        inventory.add(tmpItem3, 10);

        assertEquals(inventory.getCurrentTotal(), 45);
    }

    @Test
    public void testMaxTotalIgnore()
    {
        Inventory tmpInventory = new Inventory(-1);

        Item tmpItem = new MockItem("FooBar");
        tmpInventory.add(tmpItem, 100);

        Item tmpItem2 = new MockItem("FooBar2");
        tmpInventory.add(tmpItem2, 100);

        Item tmpItem3 = new MockItem("FooBar3");
        tmpInventory.add(tmpItem3, 100);

        assertEquals(tmpInventory.getCurrentTotal(), 0);
    }

    @org.junit.Test(expected = Error.class)
    public void testSetMaxTotalLowerThenCurrentTotal()
    {
        Inventory tmpInventory = new Inventory(100);

        Item tmpItem = new MockItem("FooBar");
        tmpInventory.add(tmpItem, 100);

        tmpInventory.setMaxTotal(50);
    }

    @org.junit.Test(expected = Error.class)
    public void testSetMaxTotalLowerThenCurrentTotalAtZero()
    {
        Inventory tmpInventory = new Inventory(100);

        Item tmpItem = new MockItem("FooBar");
        tmpInventory.add(tmpItem, 50);

        tmpInventory.setMaxTotal(0);
    }

    @Test
    public void testTotalLeft()
    {
        assertEquals(inventory.getTotalLeft(), 85);
    }

    //TODO test for getItemByID

    @Test
    public void testInventoryNames()
    {
        ArrayList<String> names = inventory.getItemNames();

        assertEquals(names.get(0), "Item A");
        assertEquals(names.get(1), "Item B");
        assertEquals(names.get(2), "Item C");

    }

    @Test
    public void testRemoveInventoryName()
    {
        inventory.remove("Item A");

        ArrayList<String> names = inventory.getItemNames();

        assertEquals(names.indexOf("Item A"), -1);
    }

    @Test
    public void testToString() throws Exception
    {


        for (int i = 0; i < 3; i++)
        {
            inventory.get("Item A").setPrice(i);
            inventory.get("Item B").setPrice(i);
            inventory.get("Item C").setPrice(i);
        }

        assertEquals(inventory.toString(), "\"inventory\":{\"maxTotal\":100,\"currentTotal\":15,\"items\":[{\"name\":\"Item A\",\"minPrice\":1.0,\"maxPrice\":10.0,\"price\":2.0,\"total\":1,\"description\":\"\",\"history\":[0.0,1.0,2.0],\"active\":false},{\"name\":\"Item B\",\"minPrice\":10.0,\"maxPrice\":20.0,\"price\":2.0,\"total\":10,\"description\":\"\",\"history\":[0.0,1.0,2.0],\"active\":false},{\"name\":\"Item C\",\"minPrice\":20.0,\"maxPrice\":30.0,\"price\":2.0,\"total\":4,\"description\":\"\",\"history\":[0.0,1.0,2.0],\"active\":false}]}");
    }

    @Test
    public void testClear()
    {
        inventory.clear();
        assertEquals(inventory.getTotalItems(), 0);
        assertEquals(inventory.getItemNames().size(), 0);
    }

}
