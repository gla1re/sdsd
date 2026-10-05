package pcperipherybuilder;

/** Concrete Implementor: simulated Bluetooth transport. */
public final class BluetoothConnection implements Connection {
    @Override
    public void connect(String deviceName) {
        System.out.println(deviceName + " connected via Bluetooth.");
    }

    @Override
    public void disconnect(String deviceName) {
        System.out.println(deviceName + " disconnected from Bluetooth.");
    }

    @Override
    public String getConnectionType() {
        return "Bluetooth";
    }
}
