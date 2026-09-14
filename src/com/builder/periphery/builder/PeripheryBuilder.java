package com.builder.periphery.builder;

import com.builder.periphery.model.PcPeripherySetup;

public interface PeripheryBuilder {
    PeripheryBuilder setKeyboard(String keyboard);
    PeripheryBuilder setMouse(String mouse);
    PeripheryBuilder setMonitor(String monitor);
    PeripheryBuilder setHeadset(String headset);
    PeripheryBuilder setDeskMatWidth(int deskMatWidthCm);
    PeripheryBuilder setRgbLighting(boolean enabled);
    PcPeripherySetup build();
}