package pcperipherybuilder;

import java.util.*;

/** Validates the complete profile before changing any device settings. */
public final class ProfileService {
    public void applyGaming(DeviceRegistry registry) { apply(registry, 16000, true); }
    public void applyOffice(DeviceRegistry registry) { apply(registry, 1200, false); }

    private void apply(DeviceRegistry registry, int dpi, boolean surround) {
        Set<String> types = new HashSet<>();
        for (String model : registry.getModels()) {
            if (!registry.isConnected(model)) {
                throw new IllegalStateException("Connect " + model + " before applying a profile");
            }
            types.add(registry.getType(model));
        }
        if (!types.containsAll(Arrays.asList("MOUSE", "KEYBOARD", "HEADSET"))) {
            throw new IllegalStateException("Profile requires a mouse, keyboard and headset");
        }
        for (String model : registry.getModels()) {
            if (registry.getType(model).equals("MOUSE")) registry.setDpi(model, dpi);
            if (registry.getType(model).equals("HEADSET")) registry.setSurroundSound(model, surround);
        }
    }
}
