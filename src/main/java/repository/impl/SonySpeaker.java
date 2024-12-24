package repository.impl;

import repository.SpeakerImp;
import org.springframework.stereotype.Component;

@Component("Sony")
public class SonySpeaker implements SpeakerImp {

    @Override
    public String makeSound() {
        return "Sony speaker is playing!!";
    }

    @Override
    public String toString(){
        return "- "+ "This is Sony speaker";
    }
}
