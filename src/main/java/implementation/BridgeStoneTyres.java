package implementation;

import interfaces.TyresImp;
import org.springframework.stereotype.Component;

@Component("BridgeStone")
public class BridgeStoneTyres implements TyresImp {

    @Override
    public String moveCar() {
        System.out.println("BridgeStone tyres is rotating!!");
        return null;
    }
}
