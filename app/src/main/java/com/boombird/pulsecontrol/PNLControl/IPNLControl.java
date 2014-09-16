package com.boombird.pulsecontrol.PNLControl;

public interface IPNLControl
{
    boolean isEnabled();

    void setEnabled(boolean enabled);

    void toggle();
}
