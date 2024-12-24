package repository.impl;

import repository.TyresImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Michelin")
@Primary
public class MichelinTyres implements TyresImp {

    @Override
    public String moveCar() {
        return "Michelin tyres is rotating!!";
    }

    @Override
    public String toString(){
        return "- "+ "This is Michelin tyres";
    }
}
