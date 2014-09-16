package com.boombird.pulsecontrol.PNLControl;

import android.content.ContentResolver;
import android.os.Build;
import android.util.Log;

public class PNLControlBuilder
{
    private static final String CLASS = PNLControl.class.getName();

    public static BasePNLControl getInstance(ContentResolver contentResolver)
    {
        if (inEmulator())
        {
            Log.i(CLASS, "using MOCK PNLControl");
            return new MockPNLControl(contentResolver);
        } else
        {
            Log.i(CLASS, "using REAL PNLControl");
            return new PNLControl(contentResolver);
        }
    }

    public static boolean inEmulator()
    {
        return Build.PRODUCT.contains("sdk");
    }
}
