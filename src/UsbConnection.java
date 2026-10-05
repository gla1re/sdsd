package pcperipherybuilder;

/** Concrete Implementor: simulated USB transport. */
public final class UsbConnection implements Connection {
    @Override
    public void connect(String deviceName) {
        System.out.println(deviceName + " connected via USB.");
    }

    @Override
    public void disconnect(String deviceName) {
        System.out.println(deviceName + " disconnected from USB.");
    }

    @Override
    public String getConnectionType() {
        return "USB";
    }
}
