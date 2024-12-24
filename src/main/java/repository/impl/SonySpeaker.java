package repository.impl;

import interfaces.SpeakerImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Sony")
@Primary
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
