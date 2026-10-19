package pcperipherybuilder;

/** Validates the whole setup before connection changes occur. */
public final class CompatibilityService {
    private final int usbPorts;
    private final boolean bluetoothSupported;

    public CompatibilityService(int usbPorts, boolean bluetoothSupported) {
        if (usbPorts < 0) throw new IllegalArgumentException("USB ports cannot be negative");
        this.usbPorts = usbPorts;
        this.bluetoothSupported = bluetoothSupported;
    }

    public void validate(DeviceRegistry registry) {
        if (registry.getModels().isEmpty()) throw new IllegalStateException("No devices selected");
        int requiredUsbPorts = 0;
        for (String model : registry.getModels()) {
            if (registry.getConnection(model).equals("USB")) requiredUsbPorts++;
            else if (!bluetoothSupported) {
                throw new IllegalStateException("Bluetooth is unavailable for " + model);
            }
        }
        if (requiredUsbPorts > usbPorts) {
            throw new IllegalStateException("Need " + requiredUsbPorts + " USB ports; available: " + usbPorts);
        }
    }
}
