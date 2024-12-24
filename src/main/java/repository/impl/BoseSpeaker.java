package repository.impl;

import repository.SpeakerImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Bose")
@Primary
public class BoseSpeaker implements SpeakerImp {

    @Override
    public String makeSound() {
        return "Bose speaker is playing!!";
    }

}
