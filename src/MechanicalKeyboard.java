package pcperipherybuilder;

/** Refined Abstraction: keyboard-specific properties. */
public final class MechanicalKeyboard extends Peripheral {
    private final String switchType;

    public MechanicalKeyboard(String model, String switchType, Connection connection) {
        super(model, connection);
        this.switchType = requireText(switchType);
    }

    @Override
    protected String getDeviceDetails() {
        return "Mechanical Keyboard: " + getModel() + " | Switches: " + switchType;
    }
}
