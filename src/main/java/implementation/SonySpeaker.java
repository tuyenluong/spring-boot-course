package implementation;

import interfaces.SpeakerImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Sony")
@Primary
public class SonySpeaker implements SpeakerImp {

    @Override
    public String makeSound() {
        System.out.println("Sony speaker is playing!!");
        return null;
    }

    @Override
    public String toString(){
        return "- "+ "This is Sony speaker";
    }
}
