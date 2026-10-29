package periphery;

import periphery.strategy.ProfileStrategy;
import java.util.List;
import java.util.Objects;

public final class PeripheryContext {
    private final DeviceRegistry registry;
    private final CompatibilityService compatibility;
    private final ConnectionManager connections;
    private ProfileStrategy profile;

    public PeripheryContext(DeviceRegistry registry, CompatibilityService compatibility,
                            ConnectionManager connections, ProfileStrategy initialProfile) {
        this.registry = Objects.requireNonNull(registry);
        this.compatibility = Objects.requireNonNull(compatibility);
        this.connections = Objects.requireNonNull(connections);
        this.profile = Objects.requireNonNull(initialProfile);
    }


    public void setProfile(ProfileStrategy newProfile) {
        this.profile = Objects.requireNonNull(newProfile, "profile");
    }

    public void activateProfile() {
        compatibility.validate(registry);
        List<String> newlyConnected = connections.connectAll(registry);
        try {
            profile.apply(registry);
        } catch (RuntimeException failure) {
            connections.disconnect(registry, newlyConnected);
            throw failure;
        }
        System.out.println("Profile applied: " + profile.name());
    }

    public void showSetup() {
        for (String model : registry.getModels()) {
            System.out.println(registry.describe(model));
        }
    }

    public void shutdown() { connections.disconnectAll(registry); }
}
