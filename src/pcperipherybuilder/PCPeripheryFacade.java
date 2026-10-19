package pcperipherybuilder;

import java.util.*;

/** Coordinates four independent subsystems through a small public API. */
public final class PCPeripheryFacade {
    private final DeviceRegistry registry = new DeviceRegistry();
    private final CompatibilityService compatibility;
    private final ConnectionManager connections;
    private final ProfileService profiles = new ProfileService();

    public PCPeripheryFacade() { this(2, true); }

    public PCPeripheryFacade(int usbPorts, boolean bluetoothSupported) {
        this(usbPorts, bluetoothSupported, Collections.emptySet());
    }

    /** Models in the set simulate disconnected/unavailable hardware. */
    public PCPeripheryFacade(int usbPorts, boolean bluetoothSupported, Set<String> unavailableModels) {
        compatibility = new CompatibilityService(usbPorts, bluetoothSupported);
        connections = new ConnectionManager(unavailableModels);
        registry.register("HyperSpeed X1", "MOUSE", "USB");
        registry.register("MechPro K87", "KEYBOARD", "BLUETOOTH");
        registry.register("SoundMax H7", "HEADSET", "USB");
    }

    public void startGamingSetup() { startSetup(true); }
    public void startOfficeSetup() { startSetup(false); }

    private void startSetup(boolean gaming) {
        compatibility.validate(registry);
        List<String> newlyConnected = connections.connectAll(registry);
        try {
            if (gaming) profiles.applyGaming(registry);
            else profiles.applyOffice(registry);
        } catch (RuntimeException failure) {
            connections.disconnect(registry, newlyConnected);
            throw failure;
        }
    }

    public void showSetup() {
        for (String model : registry.getModels()) {
            String details = model + " | " + registry.getConnection(model)
                + " | Connected: " + registry.isConnected(model);
            if (registry.getType(model).equals("MOUSE")) details += " | DPI: " + registry.getDpi(model);
            if (registry.getType(model).equals("HEADSET")) details += " | Surround: " + registry.isSurroundSound(model);
            System.out.println(details);
        }
    }

    public void shutdown() { connections.disconnectAll(registry); }
}
