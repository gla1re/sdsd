package periphery;

public enum DeviceType {
    MOUSE("DPI", 800),
    KEYBOARD("Backlight", 0),
    HEADSET("Surround", false);

    private final String settingName;
    private final Object defaultValue;

    DeviceType(String settingName, Object defaultValue) {
        this.settingName = settingName;
        this.defaultValue = defaultValue;
    }

    public String settingName() { return settingName; }
    public Object defaultValue() { return defaultValue; }
}
