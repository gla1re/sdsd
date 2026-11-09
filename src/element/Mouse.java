package element;

import visitor.PeripheralVisitor;

public class Mouse implements Peripheral {
    private final String name;
    private final double price;
    private final int dpi;

    public Mouse(String name, double price, int dpi) {
        this.name = name;
        this.price = price;
        this.dpi = dpi;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDpi() {
        return dpi;
    }

    @Override
    public void accept(PeripheralVisitor visitor) {
        visitor.visitMouse(this);
    }
}