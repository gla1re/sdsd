package pcperipherybuilder;

/** Client: composes devices and connection implementations at runtime. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        System.out.println("=== PC PERIPHERY BUILDER — BRIDGE ===");
        Peripheral mouse = new GamingMouse("HyperSpeed X1", 16000, new UsbConnection());
        Peripheral keyboard = new MechanicalKeyboard("MechPro K87", "Red", new BluetoothConnection());
        Peripheral headset = new Headset("SoundMax H7", true, new UsbConnection());

        for (Peripheral device : new Peripheral[] {mouse, keyboard, headset}) {
            System.out.println();
            device.showInfo();
            device.connect();
        }

        System.out.println("\n=== SAME MOUSE: USB -> BLUETOOTH ===");
        Peripheral originalMouse = mouse;
        mouse.setConnection(new BluetoothConnection());
        mouse.showInfo();
        System.out.println("Same object: " + (mouse == originalMouse));
        System.out.println("Still connected: " + mouse.isConnected());

        System.out.println("\n=== DISCONNECT ===");
        mouse.disconnect();
        keyboard.disconnect();
        headset.disconnect();
    }
}
