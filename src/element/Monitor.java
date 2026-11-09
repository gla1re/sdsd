package element;

import visitor.PeripheralVisitor;

public class Monitor implements Peripheral {
    private final String name;
    private final double price;
    private final int refreshRate;

    public Monitor(String name, double price, int refreshRate) {
        this.name = name;
        this.price = price;
        this.refreshRate = refreshRate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    @Override
    public void accept(PeripheralVisitor visitor) {
        visitor.visitMonitor(this);
    }
}