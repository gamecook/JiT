package com.gamecook.jit.util;

import java.text.NumberFormat;

/**
 * Created by IntelliJ IDEA.
 * User: jfreeman
 * Date: Sep 18, 2010
 * Time: 8:09:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoneyToStringUtil {

    /**
     * @param value
     * @return
     */
    public static String convertToString(double value)
    {
        return convertToString((int) value);
    }

    /**
     * @param value
     * @return
     */
    public static String convertToString(int value)
    {
        return "$"+NumberFormat.getInstance().format(value);
    }

}
