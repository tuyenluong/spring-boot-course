package repository.impl;

import interfaces.SpeakerImp;
import org.springframework.stereotype.Component;

@Component("Bose")
public class BoseSpeaker implements SpeakerImp {

    @Override
    public String makeSound() {
        return "Bose speaker is playing!!";
    }

}
