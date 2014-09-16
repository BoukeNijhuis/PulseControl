package com.boombird.pulsecontrol.PNLControl;

import android.content.ContentResolver;
import android.provider.Settings;

public class PNLControl extends BasePNLControl
{
    public PNLControl(ContentResolver contentResolver)
    {
        super(contentResolver);
    }

    @Override
    public boolean isEnabled()
    {
        boolean enabled = false;

        try
        {
            int enabledInt = Settings.System.getInt(contentResolver, NOTIFICATION_LIGHT_PULSE);
            enabled = (enabledInt == 1);
        } catch (Settings.SettingNotFoundException e)
        {
            e.printStackTrace();
        }
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        Settings.System.putInt(contentResolver, NOTIFICATION_LIGHT_PULSE, enabled ? 1 : 0);
    }
}
