package periphery.strategy;

import periphery.DeviceRegistry;
import periphery.DeviceType;

public final class PowerSaverProfile implements ProfileStrategy {
    private static final int MOUSE_DPI = 800;
    private static final int KEYBOARD_BACKLIGHT_PERCENT = 0;
    private static final boolean SURROUND_ENABLED = false;

    @Override
    public String name() { return "Power saver"; }

    @Override
    public void apply(DeviceRegistry registry) {
        for (String mouse : registry.getModelsOfType(DeviceType.MOUSE)) {
            registry.setDpi(mouse, MOUSE_DPI);
        }
        for (String keyboard : registry.getModelsOfType(DeviceType.KEYBOARD)) {
            registry.setBacklight(keyboard, KEYBOARD_BACKLIGHT_PERCENT);
        }
        for (String headset : registry.getModelsOfType(DeviceType.HEADSET)) {
            registry.setSurroundSound(headset, SURROUND_ENABLED);
        }
    }
}
