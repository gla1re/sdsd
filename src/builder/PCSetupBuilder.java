package builder;

import element.Keyboard;
import element.Mouse;
import element.Monitor;

public class PCSetupBuilder {
    private final PCSetup setup = new PCSetup();

    public PCSetupBuilder addKeyboard(String name, double price,
                                      String switchType) {
        setup.addPeripheral(new Keyboard(name, price, switchType));
        return this;
    }

    public PCSetupBuilder addMouse(String name, double price, int dpi) {
        setup.addPeripheral(new Mouse(name, price, dpi));
        return this;
    }

    public PCSetupBuilder addMonitor(String name, double price,
                                     int refreshRate) {
        setup.addPeripheral(new Monitor(name, price, refreshRate));
        return this;
    }

    public PCSetup build() {
        return setup;
    }
}