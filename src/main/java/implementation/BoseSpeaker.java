package implementation;

import interfaces.SpeakerImp;
import org.springframework.stereotype.Component;

@Component("Bose")
public class BoseSpeaker implements SpeakerImp {

    @Override
    public String makeSound() {
        System.out.println("Bose speaker is playing!!");
        return null;
    }

}
