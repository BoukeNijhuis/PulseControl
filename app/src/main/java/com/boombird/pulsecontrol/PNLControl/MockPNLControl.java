package com.boombird.pulsecontrol.PNLControl;

import android.content.ContentResolver;
import android.util.Log;

public class MockPNLControl extends BasePNLControl
{
    private static final String CLASS = MockPNLControl.class.getSimpleName();

    private boolean enabled = true;

    public MockPNLControl(ContentResolver contentResolver)
    {
        super(contentResolver);
    }

    @Override
    public boolean isEnabled()
    {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        Log.i(CLASS, "PNL set to " + enabled);
        this.enabled = enabled;
    }
}
