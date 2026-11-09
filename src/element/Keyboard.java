package element;

import visitor.PeripheralVisitor;

public class Keyboard implements Peripheral {
    private final String name;
    private final double price;
    private final String switchType;

    public Keyboard(String name, double price, String switchType){
        this.name=name;
        this.price=price;
        this.switchType=switchType;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getSwitchType(){
        return switchType;
    }
    @Override
    public void accept(PeripheralVisitor visitor){
        visitor.visitKeyboard(this);
    }
}

