package com.boombird.pulsecontrol.PNLControl;

import android.content.ContentResolver;

public class MockPNLControl extends BasePNLControl
{
    private boolean enabled = false;

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
        this.enabled = enabled;
    }
}
