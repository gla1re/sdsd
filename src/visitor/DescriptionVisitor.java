package visitor;

import element.Keyboard;
import element.Mouse;
import element.Monitor;

public class DescriptionVisitor implements PeripheralVisitor {

    @Override
    public void visitKeyboard(Keyboard keyboard) {
        System.out.println("Keyboard: " + keyboard.getName());
        System.out.println("Switch type: " + keyboard.getSwitchType());
    }

    @Override
    public void visitMouse(Mouse mouse) {
        System.out.println("Mouse: " + mouse.getName());
        System.out.println("DPI: " + mouse.getDpi());
    }

    @Override
    public void visitMonitor(Monitor monitor) {
        System.out.println("Monitor: " + monitor.getName());
        System.out.println("Refresh rate: "
                + monitor.getRefreshRate() + " Hz");
    }
}
