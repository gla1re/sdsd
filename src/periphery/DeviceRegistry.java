package periphery;

import java.util.*;

public final class DeviceRegistry {
    private final Map<String, DeviceType> types = new LinkedHashMap<>();
    private final Map<String, ConnectionType> connections = new HashMap<>();
    private final Set<String> connected = new HashSet<>();
    private final Map<String, Object> settings = new HashMap<>();

    public void register(String model, DeviceType type, ConnectionType connection) {
        model = requireText(model);
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(connection, "connection");
        if (types.containsKey(model)) throw new IllegalArgumentException("Duplicate model: " + model);
        types.put(model, type);
        connections.put(model, connection);
        settings.put(model, type.defaultValue());
    }

    public List<String> getModels() {
        return Collections.unmodifiableList(new ArrayList<>(types.keySet()));
    }

    public List<String> getModelsOfType(DeviceType type) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, DeviceType> entry : types.entrySet()) {
            if (entry.getValue() == type) result.add(entry.getKey());
        }
        return result;
    }

    public DeviceType getType(String model) { requireDevice(model); return types.get(model); }
    public ConnectionType getConnection(String model) { requireDevice(model); return connections.get(model); }
    public boolean isConnected(String model) { requireDevice(model); return connected.contains(model); }

    public void setConnected(String model, boolean value) {
        requireDevice(model);
        if (value) connected.add(model);
        else connected.remove(model);
    }

    public void setDpi(String model, int dpi) {
        if (dpi <= 0) throw new IllegalArgumentException("DPI must be positive");
        store(model, DeviceType.MOUSE, dpi);
    }

    public void setBacklight(String model, int percent) {
        if (percent < 0 || percent > 100) throw new IllegalArgumentException("Backlight must be 0..100");
        store(model, DeviceType.KEYBOARD, percent);
    }

    public void setSurroundSound(String model, boolean enabled) {
        store(model, DeviceType.HEADSET, enabled);
    }


    public String describe(String model) {
        requireDevice(model);
        return model + " | " + connections.get(model)
            + " | Connected: " + connected.contains(model)
            + " | " + types.get(model).settingName() + ": " + settings.get(model);
    }

    private void store(String model, DeviceType expected, Object value) {
        if (getType(model) != expected) {
            throw new IllegalArgumentException(model + " is not a " + expected);
        }
        settings.put(model, value);
    }

    private void requireDevice(String model) {
        if (!types.containsKey(model)) throw new IllegalArgumentException("Unknown model: " + model);
    }

    private static String requireText(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Text must not be empty");
        }
        return value.trim();
    }
}
