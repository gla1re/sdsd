package com.periphery.factory;

import com.periphery.model.GamingMouse;
import com.periphery.model.GamingKeyboard;
import com.periphery.model.IMouse;
import com.periphery.model.IKeyboard;

public class GamingPeripheryFactory implements PeripheryFactory{
    @Override
    public IKeyboard createKeyboard() {
        return new GamingKeyboard();
    }
    @Override
    public IMouse createMouse() {
        return new GamingMouse();
    }
}
