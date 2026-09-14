package com.builder.periphery;

import com.builder.periphery.builder.PcPeripheryBuilder;
import com.builder.periphery.builder.PeripheryBuilder;
import com.builder.periphery.director.PeripheryDirector;
import com.builder.periphery.model.PcPeripherySetup;

public class Main {
    public static void main(String[] args) {
        PeripheryDirector director = new PeripheryDirector();

        // 1. Build via Director (Esports Gaming Setup)
        PeripheryBuilder builder1 = new PcPeripheryBuilder();
        PcPeripherySetup esportsSetup = director.constructEsportsGamingSetup(builder1);
        System.out.println("=== DIRECTED BUILD: ESPORTS SETUP ===");
        System.out.println(esportsSetup);

        // 2. Build via Director (Minimalist Office Setup)
        PeripheryBuilder builder2 = new PcPeripheryBuilder();
        PcPeripherySetup officeSetup = director.constructMinimalistOfficeSetup(builder2);
        System.out.println("=== DIRECTED BUILD: OFFICE SETUP ===");
        System.out.println(officeSetup);

        // 3. Custom Build using Fluent API
        PcPeripherySetup customSetup = new PcPeripheryBuilder()
                .setKeyboard("Custom Keychron Q1 Pro (Lubed Switches)")
                .setMouse("Razer DeathAdder V3 Pro")
                .setMonitor("LG UltraGear 34\" OLED Ultrawide")
                .setHeadset("Beyerdynamic DT 990 Pro")
                .setDeskMatWidth(100)
                .setRgbLighting(true)
                .build();

        System.out.println("=== CUSTOM FLUENT API BUILD ===");
        System.out.println(customSetup);

        // 4. Testing Validation Rules (Triggers Exception)
        System.out.println("=== TESTING VALIDATION EXCEPTION ===");
        try {
            new PcPeripheryBuilder()
                    .setKeyboard("Keychron K2")
                    .setMouse("G305")
                    .setMonitor("24-inch HD")
                    .setDeskMatWidth(10) // Triggers Exception: < 20cm
                    .build();
        } catch (IllegalStateException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }
    }
}