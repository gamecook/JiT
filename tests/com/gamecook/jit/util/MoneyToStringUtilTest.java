package com.gamecook.jit.util;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: Jesse Freeman
 * Date: 12/12/10
 * Time: 2:30 PM
 */
public class MoneyToStringUtilTest
{

    @Test
    public void testConvertDoubleToStringWithoutRemainder()
    {
        assertEquals("$2,222", MoneyToStringUtil.convertToString(2222.00));
    }

    @Test
    public void testConvertIntToStringWithRemainder()
    {
        assertEquals("$2,222", MoneyToStringUtil.convertToString(2222));
    }
}
