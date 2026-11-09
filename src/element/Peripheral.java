package element;

import visitor.PeripheralVisitor;

public interface Peripheral {
    void accept(PeripheralVisitor visitor);
}
