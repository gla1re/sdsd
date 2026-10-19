package pcperipherybuilder;

import java.util.*;

/** Simulates connections and rolls back only devices connected by this attempt. */
public final class ConnectionManager {
    private final Set<String> unavailableModels;

    public ConnectionManager() { this(Collections.emptySet()); }

    /** Optional simulated unavailable devices, useful for demonstrating failures. */
    public ConnectionManager(Set<String> unavailableModels) {
        this.unavailableModels = new HashSet<>(Objects.requireNonNull(unavailableModels));
    }

    public List<String> connectAll(DeviceRegistry registry) {
        List<String> newlyConnected = new ArrayList<>();
        try {
            for (String model : registry.getModels()) {
                if (!registry.isConnected(model)) {
                    if (unavailableModels.contains(model)) {
                        throw new IllegalStateException("Device unavailable: " + model);
                    }
                    registry.setConnected(model, true);
                    newlyConnected.add(model);
                    System.out.println(model + " connected via " + registry.getConnection(model));
                }
            }
            return newlyConnected;
        } catch (RuntimeException failure) {
            disconnect(registry, newlyConnected);
            throw failure;
        }
    }

    public void disconnect(DeviceRegistry registry, List<String> models) {
        for (int i = models.size() - 1; i >= 0; i--) {
            String model = models.get(i);
            if (registry.isConnected(model)) {
                registry.setConnected(model, false);
                System.out.println(model + " disconnected");
            }
        }
    }

    public void disconnectAll(DeviceRegistry registry) {
        disconnect(registry, registry.getModels());
    }
}
