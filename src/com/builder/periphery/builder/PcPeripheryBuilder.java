package com.builder.periphery.builder;

import com.builder.periphery.model.PcPeripherySetup;


public class PcPeripheryBuilder implements PeripheryBuilder {
    private String keyboard;
    private String mouse;
    private String monitor;
    private String headset = "Standard Stereo Speakers";
    private int deskMatWidthCm = 30;
    private boolean hasRgbLighting = false;

    private static final int MINIMUM_DESK_MAT_WIDTH_CM = 20;

    @Override
    public PeripheryBuilder setKeyboard(String keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    @Override
    public PeripheryBuilder setMouse(String mouse) {
        this.mouse = mouse;
        return this;
    }

    @Override
    public PeripheryBuilder setMonitor(String monitor) {
        this.monitor = monitor;
        return this;
    }

    @Override
    public PeripheryBuilder setHeadset(String headset) {
        this.headset = headset;
        return this;
    }

    @Override
    public PeripheryBuilder setDeskMatWidth(int deskMatWidthCm) {
        this.deskMatWidthCm = deskMatWidthCm;
        return this;
    }

    @Override
    public PeripheryBuilder setRgbLighting(boolean enabled) {
        this.hasRgbLighting = enabled;
        return this;
    }

    @Override
    public PcPeripherySetup build() {
        validateConfiguration();
        return new PcPeripherySetup(keyboard, mouse, monitor, headset, deskMatWidthCm, hasRgbLighting);
    }

    private void validateConfiguration() {
        if (keyboard == null || keyboard.isBlank()) {
            throw new IllegalStateException("Build failed: A keyboard must be selected.");
        }
        if (mouse == null || mouse.isBlank()) {
            throw new IllegalStateException("Build failed: A mouse must be selected.");
        }
        if (monitor == null || monitor.isBlank()) {
            throw new IllegalStateException("Build failed: A monitor must be selected.");
        }
        if (deskMatWidthCm < MINIMUM_DESK_MAT_WIDTH_CM) {
            throw new IllegalStateException("Build failed: Desk mat width must be at least " + MINIMUM_DESK_MAT_WIDTH_CM + " cm.");
        }
    }
}
