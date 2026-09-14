package com.builder.periphery.model;

/**
 * Product class representing a complete peripheral setup.
 */
public class PcPeripherySetup {
    private final String keyboard;
    private final String mouse;
    private final String monitor;
    private final String headset;
    private final int deskMatWidthCm;
    private final boolean hasRgbLighting;

    public PcPeripherySetup(String keyboard, String mouse, String monitor,
                            String headset, int deskMatWidthCm, boolean hasRgbLighting) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
        this.headset = headset;
        this.deskMatWidthCm = deskMatWidthCm;
        this.hasRgbLighting = hasRgbLighting;
    }

    @Override
    public String toString() {
        return "PC Periphery Setup Specifications:\n" +
                " - Keyboard: " + keyboard + "\n" +
                " - Mouse: " + mouse + "\n" +
                " - Monitor: " + monitor + "\n" +
                " - Headset: " + headset + "\n" +
                " - Desk Mat Width: " + deskMatWidthCm + " cm\n" +
                " - Sync RGB Lighting: " + (hasRgbLighting ? "Yes" : "No") + "\n";
    }
}