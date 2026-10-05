package pcperipherybuilder;

/** Implementor: low-level connection operations. */
public interface Connection {
    void connect(String deviceName);
    void disconnect(String deviceName);
    String getConnectionType();
}
