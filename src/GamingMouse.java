package pcperipherybuilder;

/** Refined Abstraction: mouse-specific properties. */
public final class GamingMouse extends Peripheral {
    private final int dpi;

    public GamingMouse(String model, int dpi, IConnection connection) {
        super(model, connection);
        if (dpi <= 0) {
            throw new IllegalArgumentException("DPI must be positive");
        }
        this.dpi = dpi;
    }

    @Override
    protected String getDeviceDetails() {
        return "Gaming Mouse: " + getModel() + " | DPI: " + dpi;
    }
}
