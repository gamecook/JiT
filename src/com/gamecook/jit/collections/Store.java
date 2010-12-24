package com.gamecook.jit.collections;

import com.gamecook.jit.items.Item;

import java.util.*;

public class Store extends Inventory {

    public static final int BUY = 1;
    public static final int SELL = 2;
    protected int currentItemID = -1;
    protected int mode = BUY;
    protected int maxCurrentInventory = 0;
    protected ArrayList<Item> currentInventory;
    private ArrayList<Item> userInventory;

    public Item getCurrentItem() {
        return mode == BUY ? currentInventory.get(currentItemID) : userInventory.get(currentItemID) ;
    }

    public void selectItemByID(int id)
    {
        currentItemID = id;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * The Store represents a collection of items
     * with their associated prices. The store also
     * manages the inventory of each item and its
     * fluctuation in price.
     */
    public Store(int maxTotal) {
        super(maxTotal);
        currentInventory = new ArrayList<Item>();
        userInventory = new ArrayList<Item>();
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
        updateInventory();
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

    public int getCurrentItemID() {
        return currentItemID;
    }

    public double previewCurrentItemPrice(int total) {
        //TODO should this throw an error?
        if(currentItemID < 0)
            return 0.0;

        return getCurrentItem().getPrice() * total;
    }

    public String getCurrentItemName() {
        return getCurrentItem().getName();
    }

    public int previewCurrentItemMaxBuy(double total) {
        //TODO should this throw an error?
        if(currentItemID < 0)
            return 0;

        return (int) Math.floor(total / getCurrentItem().getPrice());
    }


    public void buyCurrentItem(int total) {
        add(getCurrentItem(), total);
        refreshUserInventory();
    }

    public void sellCurrentItem(int total) {
        removeFromInventory(getCurrentItem(), total);
        refreshUserInventory();
    }

    public ArrayList<Item> getCurrentInventory()
    {
        return currentInventory;

    }

    public int getMaxCurrentInventory()
    {
        return maxCurrentInventory;
    }

    public void setMaxCurrentInventory(int maxCurrentInventory)
    {
        this.maxCurrentInventory = maxCurrentInventory;
    }

    /**
     * Goes through the items and creates a list of active items the store is currently selling.
     */
    public void updateInventory()
    {
        currentInventory.clear();
        Collections.shuffle(itemNames);
        Collections.shuffle(itemNames);

        List<String> list = itemNames.subList(0, maxCurrentInventory);

        Collections.sort(list);

        int i;
        for (i = 0; i < maxCurrentInventory; i++)
        {
            currentInventory.add(get(list.get(i)));
        }
    }

    public ArrayList<Item> getUserInventory()
    {
        return userInventory;
    }

    public void refreshUserInventory()
    {
        userInventory.clear();
        int i = 0;
        int total = inventory.size();
        Item item;
        for (i = 0; i < total; i ++)
        {
            item = getItemByID(i);
            if(item.getTotal() > 0)
                userInventory.add(item);
        }
    }
}