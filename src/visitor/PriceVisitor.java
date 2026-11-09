package visitor;

import element.Keyboard;
import element.Mouse;
import element.Monitor;

public class PriceVisitor implements PeripheralVisitor {
    private double totalPrice = 0;

    @Override
    public void visitKeyboard(Keyboard keyboard) {
        totalPrice += keyboard.getPrice();
        System.out.println("Keyboard price: $" + keyboard.getPrice());
    }

    @Override
    public void visitMouse(Mouse mouse) {
        totalPrice += mouse.getPrice();
        System.out.println("Mouse price: $" + mouse.getPrice());
    }

    @Override
    public void visitMonitor(Monitor monitor) {
        totalPrice += monitor.getPrice();
        System.out.println("Monitor price: $" + monitor.getPrice());
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}