package com.gamecook.jit.state;

import sun.plugin.javascript.JSObject;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: 1/4/11
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractState
{
    protected JSObject data;

    public JSObject getData()
    {
        return data;
    }

    public void setData(JSObject data)
    {
        this.data = data;
    }

}
