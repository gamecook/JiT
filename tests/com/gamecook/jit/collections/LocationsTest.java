package com.gamecook.jit.collections;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Aug 15, 2010
 * Time: 4:34:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocationsTest
{

    private Locations locations;

    @Before
    public void createInventory()
    {
        locations = new Locations();
        locations.add("LocationA");
        locations.add("LocationB");
        locations.add("LocationC");
    }

    @Test
    public void testLocationA()
    {
        assertEquals(locations.getLocation(0), "LocationA");
    }

    @Test
    public void testAddLocation()
    {
        int id = locations.add("LocationD");
        assertEquals(locations.getLocation(id), "LocationD");
    }

    @Test
    public void testCurrentLocation()
    {
        locations.gotoLocationByID(1);
        assertEquals(locations.getCurrentLocation(), locations.getLocation(1));
    }

    @Test
    public void testGetLocation()
    {
        assertEquals(locations.getLocation(1), "LocationB");
    }

    @Test
    public void testLastLocation()
    {
        locations.gotoLocationByID(2);
        locations.gotoLocationByID(0);
        assertEquals(locations.getLastLocation(), "LocationC");
    }

    @Test
    public void testGetTotal()
    {
        assertEquals(locations.getTotal(), 3);
    }

    @Test
    public void testLastLocationID()
    {
        locations.gotoLocationByID(2);
        locations.gotoLocationByID(0);
        assertEquals(locations.getLastLocationID(), 2);
    }

    @Test
    public void testFistLocationChangeIDs()
    {
        locations.gotoLocationByID(2);
        assertEquals(locations.getLastLocationID(), -1);
    }

    @Test
    public void testFistLocationID()
    {
        assertEquals(locations.getCurrentLocationID(), -1);
    }

    @Test
    public void testGotoLocationByName()
    {
        locations.gotoLocationByName("LocationC");
        assertEquals(locations.getCurrentLocation(), "LocationC");
    }

    @Test
    public void testToString()
    {
        assertEquals(locations.toString(), "{\"locations\":{\"currentLocation\":-1,\"lastID\":0,\"names\":[\"LocationA\",\"LocationB\",\"LocationC\"]}}");
    }
}
