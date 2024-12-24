package repository.impl;

import repository.TyresImp;
import org.springframework.stereotype.Component;

@Component("BridgeStone")
public class BridgeStoneTyres implements TyresImp {

    @Override
    public String moveCar() {
        return "BridgeStone tyres is rotating!!";
    }
}
