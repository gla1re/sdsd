package com.periphery.factory;

import com.periphery.model.IMouse;
import com.periphery.model.IKeyboard;

public interface PeripheryFactory {
    IKeyboard createKeyboard();
    IMouse createMouse();
}
