package implementation;

import interfaces.SpeakerImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Bose")
@Primary
public class BoseSpeaker implements SpeakerImp {

    @Override
    public void makeSound() {
        System.out.println("Bose speaker is playing!!");
    }

}
