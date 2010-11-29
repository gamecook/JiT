package com.gamecook.jit.collections;

import com.gamecook.jit.items.Item;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

public class Store extends Inventory {



    /**
     * The Store represents a collection of items
     * with their associated prices. The store also
     * manages the inventory of each item and its
     * fluctuation in price.
     */
    public Store(int value) {
        super(value);
    }

    /**
     * This refreshes the prices of each of the
     * items. It uses the range values to calculate
     * the change in price.
     */
    public void refresh() {
        Collection<Item> items = inventory.values();
        for (Item item : items) {
            item.generateNewPrice();
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("inventory", "store");
    }

    /**
     * In the store if you remove an item and it's total is 0 it is not removed
     * from the collection.
     *
     * @param id
     * @param amount
     * @return
     */
    @Override
    public int removeFromInventory(Item id, int amount) {
        if (!hasItem(id.getName())) {
            return 0;
        } else {
            int remainder = getItemTotal(id.getName()) - amount;
            inventory.get(id.getName()).setTotal(remainder);

            subtractFromTotal(amount);

            return remainder;
        }

    }

    @Override
    public int getCurrentTotal() {

        currentTotal = 0;

        Collection c = inventory.values();

        //obtain an Iterator for Collection
        Iterator itr = c.iterator();

        //iterate through HashMap values iterator
        while(itr.hasNext())
        {
          Item item = (Item)itr.next();
          currentTotal += item.getTotal();
        }

        return currentTotal;
    }

    protected void addToTotal(int value)
    {
        if(maxTotal == -1)
            return;

        if(getCurrentTotal() > maxTotal)
            throw new Error("Current total cann't go above the Max Total.");
    }
}