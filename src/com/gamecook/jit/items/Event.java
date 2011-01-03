package com.gamecook.jit.items;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: 1/3/11
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Event
{
    private int id;
    private String description;

    public Event(int id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
