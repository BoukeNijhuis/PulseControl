package com.boombird.pulsecontrol.PNLControl;

import android.content.ContentResolver;
import android.os.Build;
import android.util.Log;

public class PNLControlBuilder
{
    private static final String CLASS = PNLControl.class.getSimpleName();

    private static BasePNLControl control;

    public static BasePNLControl getInstance(ContentResolver contentResolver)
    {
        if (control != null)
        {
            return control;
        }
        else
        {
            if (inEmulator())
            {
                Log.i(CLASS, "using MOCK PNLControl");
                control = new MockPNLControl(contentResolver);
            }
            else
            {
                Log.i(CLASS, "using REAL PNLControl");
                control = new PNLControl(contentResolver);
            }

            return control;
        }
    }

    public static boolean inEmulator()
    {
        return Build.PRODUCT.contains("sdk");
    }
}
