package com.jeremy.repository.impl;

import com.jeremy.repository.TyresImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Michelin")
@Primary
public class MichelinTyres implements TyresImp {

    @Override
    public String rotate(){
        return "Vehicle moving with the help of Michelin tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of Michelin tyres";
    }

    @Override
    public String toString(){
        return "- "+ "This is Michelin tyres";
    }
}
