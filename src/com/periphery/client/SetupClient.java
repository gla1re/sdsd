package com.periphery.client;

import com.periphery.factory.PeripheryFactory;
import com.periphery.model.IMouse;
import com.periphery.model.IKeyboard;

public class SetupClient {
        private final IKeyboard keyboard;
        private final IMouse mouse;

        public SetupClient(PeripheryFactory factory){
            validateFactory(factory);
            this.keyboard = factory.createKeyboard();
            this.mouse = factory.createMouse();
        }
        public void displaySetup(){
            System.out.println("---Periphery Setup Specs---");
            System.out.println(keyboard.getSpecifications());
            System.out.println(mouse.getSpecifications());
            System.out.println();
    }
    private void validateFactory(PeripheryFactory factory){
            if(factory == null){
                throw new IllegalArgumentException("Initalization Failed:factory cannot be null");
            }
    }
}