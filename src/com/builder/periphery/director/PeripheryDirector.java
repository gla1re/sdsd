package com.builder.periphery.director;

import com.builder.periphery.builder.PeripheryBuilder;
import com.builder.periphery.model.PcPeripherySetup;

/**
 * Director orchestrating common pre-configured peripheral setups.
 */
public class PeripheryDirector {

    public PcPeripherySetup constructMinimalistOfficeSetup(PeripheryBuilder builder) {
        return builder
                .setKeyboard("Logitech MX Keys (Silent)")
                .setMouse("Logitech MX Master 3S")
                .setMonitor("Dell UltraSharp 27\" 4K")
                .setHeadset("Sennheiser HD 560S")
                .setDeskMatWidth(40)
                .setRgbLighting(false)
                .build();
    }

    public PcPeripherySetup constructEsportsGamingSetup(PeripheryBuilder builder) {
        return builder
                .setKeyboard("Wooting 60HE (Rapid Trigger)")
                .setMouse("Logitech G Pro X Superlight 2")
                .setMonitor("BenQ ZOWIE XL2566K 360Hz")
                .setHeadset("HyperX Cloud II")
                .setDeskMatWidth(90)
                .setRgbLighting(true)
                .build();
    }
}