package com.gamecook.jit.collections;

import com.gamecook.jit.items.Item;
import com.gamecook.jit.items.MockItem;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 16, 2010
 * Time: 3:44:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreTest {
    private Store store;

    @Before
    public void setUp() throws Exception {
        store = new Store(-1);

        // Item A
        Item itemA = new MockItem("Item A");
        itemA.setMinPrice(1);
        itemA.setMaxPrice(10);
        store.add(itemA, 1);

        // Item B
        Item itemB = new MockItem("Item B");
        itemB.setMinPrice(10);
        itemB.setMaxPrice(20);
        store.add(itemB, 10);

        // Item C
        Item itemC = new MockItem("Item C");
        itemC.setMinPrice(20);
        itemC.setMaxPrice(30);
        store.add(itemC, 4);
    }

    @Test
    public void testRefresh() throws Exception {

        store.refresh();

        Item itemA = store.get("Item A");
        assertTrue(itemA.getPrice() <= itemA.getMaxPrice() && itemA.getPrice() >= itemA.getMinPrice());
    }

    @Test
    public void testToString() throws Exception {


        for (int i = 0; i < 3; i++)
        {
            store.get("Item A").setPrice(i);
            store.get("Item B").setPrice(i);
            store.get("Item C").setPrice(i);
        }

        assertEquals(store.toString(), "{\"store\":{\"maxTotal\":-1,\"currentTotal\":15,\"items\":[{\"name\":\"Item A\",\"minPrice\":1.0,\"maxPrice\":10.0,\"price\":2.0,\"total\":1,\"description\":\"\",\"history\":[0.0,1.0,2.0],\"active\":false},{\"name\":\"Item B\",\"minPrice\":10.0,\"maxPrice\":20.0,\"price\":2.0,\"total\":10,\"description\":\"\",\"history\":[0.0,1.0,2.0],\"active\":false},{\"name\":\"Item C\",\"minPrice\":20.0,\"maxPrice\":30.0,\"price\":2.0,\"total\":4,\"description\":\"\",\"history\":[0.0,1.0,2.0],\"active\":false}]}}");
    }

    @Test
    public void testRemoveItemIsNull()
    {
        Item tmpItem = new MockItem("FooBar");
        store.add(tmpItem, 10);
        store.removeFromInventory(tmpItem, 10);
        assertNotNull(store.get("FooBar"));
    }

    @Test
    public void testGetCurrentTotal()
    {
        assertEquals(15, store.getCurrentTotal());
    }

    @Test
    public void testGetCurrentItem()
    {
        store.selectItemByID(2);
        assertEquals("Item C", store.getCurrentItem().getName());
    }

    @Test
    public void testGetCurrentItemID()
    {
        store.selectItemByID(1);
        assertEquals(1, store.getCurrentItemID());
    }

    @Test
    public void setMode()
    {
        store.setMode(Store.BUY);
        assertEquals(1, store.getMode());
    }

    @Test
    public void testGetCurrentItemName()
    {
        store.selectItemByID(2);
        assertEquals("Item C", store.getCurrentItemName());
    }

    @Test
    public void testPreviewCurrentItemPrice()
    {
        store.selectItemByID(0);
        store.getCurrentItem().setPrice(5.0);
        double tmpPrice = store.previewCurrentItemPrice(5);
        assertEquals(25.0, tmpPrice);

    }

    @Test
    public void testPreviewNoCurrentItemSelectedPrice()
    {
        double tmpPrice = store.previewCurrentItemPrice(5);
        assertEquals(0.0, tmpPrice);
    }

    @Test
    public void testPreviewCurrentItemMaxBuy()
    {
        store.selectItemByID(1);
        store.getCurrentItem().setPrice(25);

        assertEquals(4, store.previewCurrentItemMaxBuy(100));
    }

    @Test
    public void testPreviewNoCurrentItemSelectedMaxBuy()
    {
        assertEquals(0, store.previewCurrentItemMaxBuy(100));
    }

    @Test
    public void testBuyCurrentItem()
    {
        store.selectItemByID(0);
        store.buyCurrentItem(5);
        assertEquals(6, store.getCurrentItem().getTotal());
    }

    @Test
    public void testSellCurrentItem()
    {
        store.selectItemByID(1);
        store.sellCurrentItem(5);
        assertEquals(5, store.getCurrentItem().getTotal());
    }
}