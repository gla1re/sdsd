package com.periphery.factory;

import com.periphery.model.IKeyboard;
import com.periphery.model.IMouse;
import com.periphery.model.OfficeMouse;
import com.periphery.model.OfficeKeyboard;

public class OfficePeripheryFactory implements PeripheryFactory {
    @Override
    public IKeyboard createKeyboard(){
        return new OfficeKeyboard();
    }
    @Override
    public IMouse createMouse(){
        return new OfficeMouse();
    }
}
