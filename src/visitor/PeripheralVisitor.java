package visitor;

import element.Keyboard;
import element.Mouse;
import element.Monitor;

public interface PeripheralVisitor {
    void visitKeyboard(Keyboard keyboard);
    void visitMouse(Mouse mouse);
    void visitMonitor(Monitor monitor);
}