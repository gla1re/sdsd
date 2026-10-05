package pcperipherybuilder;

/** Refined Abstraction: headset-specific properties. */
public final class Headset extends Peripheral {
    private final boolean surroundSound;

    public Headset(String model, boolean surroundSound, Connection connection) {
        super(model, connection);
        this.surroundSound = surroundSound;
    }

    @Override
    protected String getDeviceDetails() {
        return "Headset: " + getModel() + " | Surround sound: " + surroundSound;
    }
}
