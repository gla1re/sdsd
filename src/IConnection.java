package pcperipherybuilder;

/** Implementor: low-level connection operations. */
public interface IConnection {
    void connect(String deviceName);
    void disconnect(String deviceName);
    String getConnectionType();
}
