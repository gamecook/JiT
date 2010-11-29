package com.gamecook.jit.collections;

import com.gamecook.jit.items.Item;

import java.util.Collection;
import java.util.Enumeration;
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
}