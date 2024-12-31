package com.jeremy.repository.impl;

import com.jeremy.repository.TyresImp;
import org.springframework.stereotype.Component;

@Component("BridgeStone")
public class BridgeStoneTyres implements TyresImp {

    @Override
    public String rotate(){
        return "Vehicle moving with the help of BridgeStone tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of BridgeStone tyres";
    }
}
