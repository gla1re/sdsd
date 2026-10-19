package pcperipherybuilder;

import java.util.*;

/** Stores devices and their simulated connection/settings state. */
public final class DeviceRegistry {
    private final Map<String, String> types = new LinkedHashMap<>();
    private final Map<String, String> connections = new HashMap<>();
    private final Set<String> connected = new HashSet<>();
    private final Map<String, Integer> mouseDpi = new HashMap<>();
    private final Map<String, Boolean> surroundSound = new HashMap<>();

    public void register(String model, String type, String connection) {
        model = requireText(model);
        type = requireText(type).toUpperCase(Locale.ROOT);
        connection = requireText(connection).toUpperCase(Locale.ROOT);
        if (types.containsKey(model)) throw new IllegalArgumentException("Duplicate model: " + model);
        if (!Arrays.asList("MOUSE", "KEYBOARD", "HEADSET").contains(type)) {
            throw new IllegalArgumentException("Unknown device type: " + type);
        }
        if (!Arrays.asList("USB", "BLUETOOTH").contains(connection)) {
            throw new IllegalArgumentException("Unknown connection: " + connection);
        }
        types.put(model, type);
        connections.put(model, connection);
        if (type.equals("MOUSE")) mouseDpi.put(model, 800);
        if (type.equals("HEADSET")) surroundSound.put(model, false);
    }

    private static String requireText(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Text must not be empty");
        }
        return value.trim();
    }

    private void requireDevice(String model) {
        if (!types.containsKey(model)) throw new IllegalArgumentException("Unknown model: " + model);
    }

    public List<String> getModels() {
        return Collections.unmodifiableList(new ArrayList<>(types.keySet()));
    }

    public String getType(String model) { requireDevice(model); return types.get(model); }
    public String getConnection(String model) { requireDevice(model); return connections.get(model); }
    public boolean isConnected(String model) { requireDevice(model); return connected.contains(model); }

    public void setConnected(String model, boolean value) {
        requireDevice(model);
        if (value) connected.add(model);
        else connected.remove(model);
    }

    public void setDpi(String model, int dpi) {
        if (!getType(model).equals("MOUSE") || dpi <= 0) {
            throw new IllegalArgumentException("Positive DPI requires a mouse");
        }
        mouseDpi.put(model, dpi);
    }

    public int getDpi(String model) {
        if (!getType(model).equals("MOUSE")) throw new IllegalArgumentException("Not a mouse");
        return mouseDpi.get(model);
    }

    public void setSurroundSound(String model, boolean enabled) {
        if (!getType(model).equals("HEADSET")) throw new IllegalArgumentException("Not a headset");
        surroundSound.put(model, enabled);
    }

    public boolean isSurroundSound(String model) {
        if (!getType(model).equals("HEADSET")) throw new IllegalArgumentException("Not a headset");
        return surroundSound.get(model);
    }
}
