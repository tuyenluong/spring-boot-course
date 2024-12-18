package implementation;

import interfaces.TyresImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("BridgeStone")
@Primary
public class BridgeStoneTyres implements TyresImp {

    @Override
    public void moveCar() {
        System.out.println("BridgeStone tyres is rotating!!");
    }
}
