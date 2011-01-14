package com.gamecook.jit.items;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 15, 2010
 * Time: 5:43:47 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractItem implements Item
{

    protected double minPrice = 0;
    protected double maxPrice = 0;
    protected double price = 0;
    protected String name = "undefined";
    protected String description = "";
    protected int total;
    protected boolean active;
    protected Random randomGenerator;
    protected ArrayList<Double> priceHistory;

    public int getMaxHistory()
    {
        return maxHistory;
    }

    public void setMaxHistory(int maxHistory)
    {
        this.maxHistory = maxHistory;
    }

    protected int maxHistory = -1;
    /**
     * Returns is the item is flagged as active.
     *
     * @return
     */
    public boolean isActive()
    {
        return active;
    }

    /**
     * Sets the active value of the item.
     *
     * @param active
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }


    /**
     * An Abstract class to represent an Item that can be used
     * with JiT. Items can randomly generate their price based
     * on a min/max or can be explicitly set. Also Items can
     * have a total representing how many of each are in a
     * collection.
     *
     * @param name the name of the Item.
     */
    public AbstractItem(String name)
    {
        this.name = name;
        priceHistory = new ArrayList<Double>();
        randomGenerator = new Random();

    }

    /**
     * Returns the min price for the item.
     *
     * @return
     */
    public double getMinPrice()
    {
        return minPrice;
    }

    /**
     * Sets the Minimum Price for the Item. This is used when
     * randomly generating a new price.
     *
     * @param value
     */
    public void setMinPrice(double value)
    {
        minPrice = value < 0 ? 0 : value;
    }

    /**
     * @return
     */
    public double getMaxPrice()
    {
        return maxPrice;
    }

    /**
     * Sets the Maximum price for the Item. This is used when
     * randomly generating a new price.
     *
     * @param value
     */
    public void setMaxPrice(double value)
    {
        maxPrice = value <= minPrice ? minPrice : value;
    }

    /**
     * @return
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns the price of the item.
     *
     * @param value
     */
    public void setPrice(double value)
    {
        price = value < 0 ? 0 : value;
        //TODO need to addCash in logic to limit the max number of price history.
        addToHistory(price);
    }

    protected void addToHistory(double value)
    {
        priceHistory.add(value);

        if(maxHistory > 0 && priceHistory.size() > maxHistory)
        {
            priceHistory.remove(0);
        }
    }

    /**
     * Returns the name of the Item. The name is read only and
     * lock in at the time of construction.
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the description of the Item.
     *
     * @return
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets a description for the item.
     *
     * @param value
     */
    public void setDescription(String value)
    {
        description = value;
    }

    /**
     * This generates a new price for the Item based on it's
     * min/max price. It returns the new price.
     *
     * @return
     */
    public double generateNewPrice()
    {
        setPrice(Math.round(minPrice + randomGenerator.nextDouble() * maxPrice));
        return price;
    }

    /**
     * Returns total number of items in an instance.
     *
     * @return
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * Sets a new total for the items of an instance. This overrides
     * any previous value.
     *
     * @param value
     */
    public void setTotal(int value)
    {
        if (value == total)
            return;

        total = value < 0 ? 0 : value;
    }

    /**
     * An abstract clone method for AbstractItem.
     *
     * @param name
     * @return
     */
    abstract public Item clone(String name);

    public ArrayList<Double> getPriceHistory()
    {
        return priceHistory;
    }

    public String priceHistoryToString(String delimiter)
    {
        if (delimiter == null)
            delimiter = ",";
        StringBuilder sb = new StringBuilder();
        int total = priceHistory.size();
        int i;
        for (i = 0; i < total; i++)
        {
            sb.append(Double.toString(priceHistory.get(i)));
            if (i + 1 < total)
                sb.append(delimiter);
        }

        return sb.toString();
    }

    public void parsePriceHistoryString(String history)
    {
        String[] prices = history.split(",");
        int total = prices.length;
        int i;
        double d;
        for (i = 0; i < total; i++)
        {
            try
            {
                d = Double.valueOf(prices[i].trim()).doubleValue();
                setPrice(d);
            } catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
    }

    @Override
    public String toString()
    {
        return "{\"name\":\"" + getName() + "\"," +
                "\"minPrice\":" + minPrice + "," +
                "\"maxPrice\":" + maxPrice + "," +
                "\"price\":" + price + "," +
                "\"total\":" + total + "," +
                "\"description\":\"" + description + "\"," +
                "\"history\":[" + priceHistoryToString(",") + "]," +
                "\"active\":" + active + "" +
                "}";
    }


}
