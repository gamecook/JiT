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
     * Returns the current location.
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

    public void gotoLocationByName(String name)
    {
        gotoLocationByID(locations.indexOf(name));
    }

    public int getCurrentLocationID()
    {
        return currentLocation;
    }

    @Override
    public String toString()
    {

        String output = "\"locations\":{\"currentLocation\":" + currentLocation + ",\"lastID\":" + lastID + ",\"names\":[";

        int i;
        int total = locations.size();

        for (i = 0; i < total; i++)
        {
            output += "\"" + locations.get(i) + "\",";
        }

        return output.substring(0, output.length() - 1) + "]}";
    }

    public void setCurrentLocation(int value)
    {
        currentLocation = value;
    }

    public void setLastID(int value)
    {
        lastID = value;
    }
}
