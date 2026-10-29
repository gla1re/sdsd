package periphery;

import periphery.strategy.*;
import java.util.Collections;

public final class Main {
    private Main() { }

    private static final class StreamingProfile implements ProfileStrategy {
        @Override public String name() { return "Streaming"; }

        @Override
        public void apply(DeviceRegistry registry) {
            for (String mouse : registry.getModelsOfType(DeviceType.MOUSE)) registry.setDpi(mouse, 3200);
            for (String keyboard : registry.getModelsOfType(DeviceType.KEYBOARD)) registry.setBacklight(keyboard, 70);
            for (String headset : registry.getModelsOfType(DeviceType.HEADSET)) registry.setSurroundSound(headset, true);
        }
    }

    private static DeviceRegistry createRegistry() {
        DeviceRegistry registry = new DeviceRegistry();
        registry.register("HyperSpeed X1", DeviceType.MOUSE, ConnectionType.USB);
        registry.register("MechPro K87", DeviceType.KEYBOARD, ConnectionType.BLUETOOTH);
        registry.register("SoundMax H7", DeviceType.HEADSET, ConnectionType.USB);
        return registry;
    }

    public static void main(String[] args) {
        PeripheryContext context = new PeripheryContext(createRegistry(),
            new CompatibilityService(2, true), new ConnectionManager(), new GamingProfile());
        try {
            run(context, "GAMING");
            context.setProfile(new OfficeProfile());
            run(context, "OFFICE");
            context.setProfile(new PowerSaverProfile());
            run(context, "POWER SAVER");
            context.setProfile(new StreamingProfile());
            run(context, "STREAMING (new strategy, no existing class changed)");
        } finally {
            context.shutdown();
        }

        System.out.println("\n=== FAILURE: headset unavailable -> rollback ===");
        PeripheryContext broken = new PeripheryContext(createRegistry(),
            new CompatibilityService(2, true),
            new ConnectionManager(Collections.singleton("SoundMax H7")), new GamingProfile());
        try {
            broken.activateProfile();
        } catch (RuntimeException failure) {
            System.err.println("Setup failed: " + failure.getMessage());
        }
        broken.showSetup();
    }

    private static void run(PeripheryContext context, String title) {
        System.out.println("\n=== " + title + " ===");
        context.activateProfile();
        context.showSetup();
    }
}
