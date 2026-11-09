package builder;

import element.Peripheral;
import visitor.PeripheralVisitor;

import java.util.ArrayList;
import java.util.List;

public class PCSetup {
    private final List<Peripheral> peripherals = new ArrayList<>();

    public void addPeripheral(Peripheral peripheral) {
        peripherals.add(peripheral);
    }

    public void accept(PeripheralVisitor visitor) {
        for (Peripheral peripheral : peripherals) {
            peripheral.accept(visitor);
        }
    }
}