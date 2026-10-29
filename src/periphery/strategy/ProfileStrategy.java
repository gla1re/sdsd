package periphery.strategy;

import periphery.DeviceRegistry;

public interface ProfileStrategy {
    String name();

    void apply(DeviceRegistry registry);
}
