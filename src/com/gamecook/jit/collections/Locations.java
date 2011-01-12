package com.gamecook.jit.collections;

import java.util.ArrayList;


public class Locations
{
    protected int currentLocation = -1;
    protected int lastID;
    protected ArrayList<String> locations = new ArrayList<String>();

    /**
     * The map represent a collection of collections.
     * It tracks the current and last location visited.
     */
    public Locations()
    {

    }

    public int add(String value)
    {
        if (!locations.contains(value))
            locations.add(value);

        return locations.indexOf(value);
    }

    /**
     * Tells the map what location is currently
     * being visited.
     *
     * @param id
     */
    public String gotoLocationByID(int id)
    {
        lastID = currentLocation;

        currentLocation = id;

        return locations.get(currentLocation);
    }

    /**
     * Returns the current loctaion.
     *
     * @return
     */
    public String getCurrentLocation()
    {
        return locations.get(currentLocation);
    }

    /**
     * Returns the location itself by ID.
     *
     * @param id
     * @return
     */
    public String getLocation(int id)
    {
        return locations.get(id);
    }

    /**
     * returns the last location visited.
     *
     * @return
     */
    public String getLastLocation()
    {
        return locations.get(lastID);
    }

    public int getLastLocationID()
    {
        return lastID;
    }

    public int getTotal()
    {
        return locations.size();
    }

    //TODO this needs a unit test
    public void gotoLocationByName(String name)
    {
        gotoLocationByID(locations.indexOf(name));
    }

    public int getCurrentLocationID()
    {
        return currentLocation;
    }
}
