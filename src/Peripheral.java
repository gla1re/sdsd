package pcperipherybuilder;

import java.util.Objects;

/** Abstraction: device behavior delegates connection work to an Implementor. */
public abstract class Peripheral {
    private final String model;
    private IConnection connection;
    private boolean connected;

    protected Peripheral(String model, IConnection connection) {
        this.model = requireText(model);
        this.connection = Objects.requireNonNull(connection, "Connection is required");
    }

    protected static String requireText(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Text must not be empty");
        }
        return value.trim();
    }

    public final void connect() {
        if (!connected) {
            connection.connect(model);
            connected = true;
        }
    }

    public final void disconnect() {
        if (connected) {
            connection.disconnect(model);
            connected = false;
        }
    }

    /** Switch the same device; reconnect only if it was already connected. */
    public final void setConnection(IConnection newConnection) {
        Objects.requireNonNull(newConnection, "Connection is required");
        if (connection == newConnection) {
            return;
        }
        boolean reconnect = connected;
        disconnect();
        connection = newConnection;
        if (reconnect) {
            connect();
        }
    }

    public final String getModel() {
        return model;
    }

    public final String getConnectionType() {
        return connection.getConnectionType();
    }

    public final boolean isConnected() {
        return connected;
    }

    public final void showInfo() {
        System.out.println(getDeviceDetails());
        System.out.println("Connection: " + getConnectionType());
    }

    protected abstract String getDeviceDetails();
}
