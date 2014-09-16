package com.boombird.pulsecontrol.PNLControl;

import android.content.ContentResolver;

public abstract class BasePNLControl implements IPNLControl
{
    public static final String NOTIFICATION_LIGHT_PULSE = "notification_light_pulse";

    ContentResolver contentResolver;

    public BasePNLControl(ContentResolver contentResolver)
    {
        this.contentResolver = contentResolver;
    }

    public void toggle()
    {
        setEnabled(!isEnabled());
    }
}
